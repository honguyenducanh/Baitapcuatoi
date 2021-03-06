package com.demo.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

public class Tag2 extends RequestContextAwareTag {

    private static final long serialVersionUID = 1L;

    @Override
    public void doFinally() {
        JspWriter out = pageContext.getOut();
        try {
            String jspPage = "../tags/tag2.jsp";
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            request.setAttribute("age", 20);
            request.setAttribute("username", "abc");
            request.getRequestDispatcher(jspPage);
            pageContext.include(jspPage);
        } catch (Exception e) {
            try {
                out.print(e.getMessage());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    protected int doStartTagInternal() throws Exception {
        return 0;
    }

}