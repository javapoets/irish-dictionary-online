<%!
    org.apache.logging.log4j.Logger log;
    public void jspInit() {
        log = org.apache.logging.log4j.LogManager.getLogger();
        log.debug("jspInit()");
        log.debug("log = " + log);
    }
%>