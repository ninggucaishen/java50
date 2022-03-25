package cc.heikafei.test;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * 邮件测试
 */
public class mailTest {

    //发件人邮箱账号、密码
    private static String username = "******@126.com";
    private static String password = "******";

    //发件人邮箱的smtp服务器地址
    private static String smtp = "smtp.126.com";

    //收件人邮箱
    private static String receiveMailAccount = "******@qq.com";

    public static void main(String[] args) throws UnsupportedEncodingException, MessagingException {

        //1.创建参数配置，用于连接邮箱服务器的参数配置
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");     //使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", smtp);      //发件人邮箱的smtp服务器地址
        props.setProperty("mail.smtp.post", "465");
        props.setProperty("mail.smtp.auth", "true");       //需要请求认证
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.password", password);

        //2.根据配置创建会话对象，用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);     //可查看详细的发送log

        //3.创建一封邮件
        MimeMessage message = createMimeMessage(session, username, receiveMailAccount);

        //4.根据Session获取邮件传输对象
        Transport transport = session.getTransport();

        //5.使用 邮箱账号、密码 连接邮件服务器，这里认证的邮箱必须与message中的发件人邮箱一致
        transport.connect(username, password);

        //6.发送邮件
        transport.sendMessage(message, message.getAllRecipients());

        //7.关闭连接
        transport.close();

    }

    /**
     * 创建一个包含文本的简单邮件
     *
     * @param session 和邮箱服务器的会话
     * @param username 发件人邮箱账号
     * @param receiveMailAccount 收件人邮箱账号
     * @return
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    private static MimeMessage createMimeMessage(Session session, String username, String receiveMailAccount) throws MessagingException, UnsupportedEncodingException {

        //1.创建一封邮件
        MimeMessage message = new MimeMessage(session);

        //2.From：发件人（可设置昵称）
        message.setFrom(new InternetAddress(username, "126_email", "UTF-8"));

        //3.To：收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMailAccount, "ning", "UTF-8"));

        //4.Subject：邮件主题（可设置标题）
        message.setSubject("First e-mail via java", "UTF-8");

        //5.Content：邮件正文
        message.setContent("hello, ning", "text/html;charset=UTF-8");

        //6.设置邮件发送时间
        message.setSentDate(new Date());

        //7.保存设置
        message.saveChanges();

        return message;

    }

}
