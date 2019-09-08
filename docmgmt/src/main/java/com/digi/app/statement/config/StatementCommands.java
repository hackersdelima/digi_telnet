package com.digi.app.statement.config;

import com.digi.app.telnet.config.TelnetUser;

public class StatementCommands {
    public static String miniStatementParamAccountNo="ENQUIRY.SELECT,,"+ TelnetUser.username +"/"+TelnetUser.password+"/,ADBL.IPS.ACCT.MINI.STMT,ACCOUNT.NO:=";
}
