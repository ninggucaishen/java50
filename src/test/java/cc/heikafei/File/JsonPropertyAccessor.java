package cc.heikafei.File;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.expression.AccessException;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.PropertyAccessor;
import org.springframework.expression.TypedValue;

import java.util.Optional;

/**
 * @author 陈敏
 * @version JsonPropertyAccessor.java, v 1.1 2021/4/27 10:19 chenmin Exp $
 * Created on 2021/4/27
 * 
 */
public class JsonPropertyAccessor implements PropertyAccessor {

    @Override
    public Class<?>[] getSpecificTargetClasses() {
        return new Class<?>[]{JSONObject.class, JSONArray.class, String.class, JSON.class};
    }

    @Override
    public boolean canRead(EvaluationContext context, Object target, String name) throws AccessException {
        if (target instanceof JSON) {
            return true;
        } else if (target instanceof String) {
            try {
                return canRead(context, JSONUtil.parse(target), name);
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public TypedValue read(EvaluationContext context, Object target, String name) throws AccessException {
        Object value = JSONUtil.getByPath(JSONUtil.parse(target), name);
        if (ObjectUtil.isNotEmpty(value)) {
            if (value instanceof String && value.toString().length() >= 14) {
                try {
                    DateTime dateTime = DateUtil.parse(value.toString());
                    return new TypedValue(dateTime.toString());
                } catch (Exception ignored) {}
            }
        }
        return new TypedValue(Optional.ofNullable(value).orElse(""));
    }

    @Override
    public boolean canWrite(EvaluationContext context, Object target, String name) throws AccessException {
        return true;
    }

    @Override
    public void write(EvaluationContext context, Object target, String name, Object newValue) throws AccessException {
        JSON targetObj = JSONUtil.parse(target);
        JSONUtil.putByPath(targetObj, name, newValue);
        if (target instanceof String) {
            target = targetObj.toString();
        }
    }
}
