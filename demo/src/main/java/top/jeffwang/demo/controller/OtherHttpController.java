package top.jeffwang.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherHttpController {
    private Map<String, Object> params = new HashMap<>();

    /**
     * 功能描述：测试PostMapping
     * 提交
     * @param id
     * @param pwd
     * @return
     */
    @PostMapping("/v1/login")
    public Object login(String id, String pwd){
        params.clear();
        params.put("id", id);
        params.put("pwd", pwd);
        return params;
    }

    /**
     * 功能描述：测试PutMapping
     * 更新
     * @param id
     * @return
     */
    @PutMapping("/v1/put")
    public Object put(String id){
        params.clear();
        params.put("id", id);
        return params;
    }

    /**
     * 功能描述：测试DeleteMapping
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/v1/del")
    public Object del(String id){
        params.clear();
        params.put("id", id);
        return params;
    }
}
