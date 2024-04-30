package com.alexander.ticketsystemjpa.logger;

import com.alexander.ticketsystemjpa.TicketSystemJpaApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SystemLogger {
    Logger logger = LoggerFactory.getLogger(TicketSystemJpaApplication.class);

}
