package com.obv.qa.util;

import com.obv.qa.base.TestBase;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import static com.obv.qa.base.TestBase.*;

public class SendEmail {
    public static void NotifyFailure(String methodName, String className) throws EmailException {


        System.out.println("Starting to send mail!!");
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(587);//465
        email.setAuthenticator(new DefaultAuthenticator(sendEmailId, sendEmailPass));
        email.setSSLOnConnect(true);
        email.setFrom(String.valueOf(email));
        email.setSubject("TestMail");

        String message="Greetings from Droom OBV\n\nThis is an autogenerated mail sent because of a test case failure in OrangeBookValue Automation.\n\n"+
                "Failure Details:\n"+"Test Class Name: "+className+"\n\n"+"Test Method Name: "
                +methodName+"\n\nKindly check Extent Report for more details."
                +"\n\nThanks and Regards\nOrange Book Value Automation\nDroom";
        email.setMsg(message);
        email.addTo(sendEmailTo);
        email.send();

        System.out.println("Email sent");
    }
}