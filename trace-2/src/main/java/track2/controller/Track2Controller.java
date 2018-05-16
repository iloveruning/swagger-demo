package track2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author llchen12
 * @date 2018/5/16
 */
@RestController
@RequestMapping("/trace-2")
public class Track2Controller {

    private Logger logger=LoggerFactory.getLogger(Track2Controller.class);


    @GetMapping
    public String track(HttpServletRequest request){
        logger.info("=====<call trace-2,TraceId={},SpanId={}>========",
                request.getHeader("X-B3-TraceId"),request.getHeader("X-B3-SpanId"));
        return "Trace";
    }
}
