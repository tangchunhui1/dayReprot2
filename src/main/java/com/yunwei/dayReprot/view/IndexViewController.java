package com.yunwei.dayReprot.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/*    */
@Controller
/*    */ public class IndexViewController
        /*    */ {
    /*    */
    @RequestMapping({"/"})
    /*    */ public String login() {
        /* 23 */
        return "login";
        /*    */
    }

    /*    */
    @RequestMapping({"/yunwei"})
    /*    */ public String welcome() {
        /* 32 */
        return "kanban";
        /*    */
    }
    /*    */
}

