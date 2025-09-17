package com.example.demo.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service("purchaseOrderService")
public class PurchaseOrderImpl implements IPurchaseOrder {
	@Autowired
    private JavaMailSender sender;   // Auto-configured mail sender

    @Value("${spring.mail.username}")
    private String fromEmail;        // Sender’s email

    @Override
    public String purchase(String[] items, double[] prices, String[] toEmails) throws Exception {
        // Calculate bill
        double billAmt = 0.0;
        for (double p : prices) {
            billAmt += p;
        }

        String msg = Arrays.toString(items) + " with prices " +
                     Arrays.toString(prices) + " are purchased with Bill Amount = " + billAmt;

        // Send mail
        String status = sendMail(msg, toEmails);
        return msg + " ----> " + status;
    }

    private String sendMail(String msg, String[] toEmails) throws Exception {
        // Create empty email message
        MimeMessage message = sender.createMimeMessage();

        // Use helper for easy setup
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(fromEmail);
        helper.setTo(toEmails);
        helper.setSubject("Purchase Confirmation");
        helper.setSentDate(new Date());
        helper.setText(msg);

        // Add attachment (optional)
        helper.addAttachment("nit.jpg", new ClassPathResource("nit.jpg"));

        // Send mail
        sender.send(message);
        return "Mail sent successfully!";
    }
}
