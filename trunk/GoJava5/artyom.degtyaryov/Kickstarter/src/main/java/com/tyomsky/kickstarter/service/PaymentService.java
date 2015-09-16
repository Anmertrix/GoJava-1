package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.domain.Payment;
import com.tyomsky.kickstarter.domain.Project;

public interface PaymentService {

    boolean processPayment(Payment payment);

    boolean processPayment(Project project, int amount, String payer);

}
