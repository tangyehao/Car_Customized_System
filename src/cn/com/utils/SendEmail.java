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
        //����smtp(���ʼ�Э��)
        pop.put("mail.smtp.host", "smtp.qq.com");
        pop.put("mail.transport.protocol", "smtp");
        //����ʼ��Ự����
        Session session = Session.getDefaultInstance(pop,null);

        //�ʼ���Ϣ����
        Message msg = new MimeMessage(session);
        try {
            //������
            msg.setFrom(new InternetAddress(eb.getFrom()));
            //�ռ���
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(eb.getRecipient()));
            //�ʼ�����
            msg.setSubject(eb.getSubject());
            msg.setText(eb.getText());
            //����ı�
            msg.saveChanges();
            //������Ӷ���
            Transport tp = session.getTransport("smtp");
            //��������(��һ������Ϊ����������������������������163����:smtp.163.com,�����qq���䣺smtp.qq.com)
            tp.connect("smtp.qq.com",eb.getFrom(), eb.getPassword());
            //�����ʼ�
            tp.sendMessage(msg, msg.getAllRecipients());
            //�ر�����
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
