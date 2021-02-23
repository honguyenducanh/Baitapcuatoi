package com.demo.tags;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.demo.entities.Product;

public class Tag3 extends RequestContextAwareTag {

    private static final long serialVersionUID = 1L;

    @Override
    public void doFinally() {
        JspWriter out = pageContext.getOut();
        try {
            String jspPage = "../tags/tag3.jsp";
            HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
            request.setAttribute("product", new Product("p01", "name 1", 4.5));
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