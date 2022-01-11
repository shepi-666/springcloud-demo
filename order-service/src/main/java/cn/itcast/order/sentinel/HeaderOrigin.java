package cn.itcast.order.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class HeaderOrigin implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest request) {
        // 获取请求头
        String header = request.getHeader("origin");
        // 非空的判断
        if (StringUtils.isEmpty(header)) {
            header = "blank";
        }
        return header;
    }
}
