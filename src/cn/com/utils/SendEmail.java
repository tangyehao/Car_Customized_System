package cn.com.utils;

import cn.com.beans.EmailBean;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public final class SendEmail {
    private SendEmail() {

    }
    public static boolean SendMsg(EmailBean eb) {
        boolean bool = false;
        Properties pop = new Properties();
        //设置smtp(发邮件协议)
        pop.put("mail.smtp.host", "smtp.qq.com");
        pop.put("mail.transport.protocol", "smtp");
        //获得邮件会话对象
        Session session = Session.getDefaultInstance(pop,null);

        //邮件消息对象
        Message msg = new MimeMessage(session);
        try {
            //发件人
            msg.setFrom(new InternetAddress(eb.getFrom()));
            //收件人
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(eb.getRecipient()));
            //邮件主题
            msg.setSubject(eb.getSubject());
            msg.setText(eb.getText());
            //保存改变
            msg.saveChanges();
            //获得连接对象
            Transport tp = session.getTransport("smtp");
            //创建连接(第一个参数为发件人邮箱服务器，如果发件人是163邮箱:smtp.163.com,如果是qq邮箱：smtp.qq.com)
            tp.connect("smtp.qq.com",eb.getFrom(), eb.getPassword());
            //发送邮件
            tp.sendMessage(msg, msg.getAllRecipients());
            //关闭连接
            tp.close();
            bool = true;
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bool;
    }

}
