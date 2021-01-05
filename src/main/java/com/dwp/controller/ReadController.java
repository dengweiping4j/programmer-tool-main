package com.dwp.controller;

import com.dwp.service.ReadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调度redis控制类
 *
 * @author dengweiping
 * @date 2020/12/31 11:50
 */
@RestController
@RequestMapping("/api/read")
public class ReadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadController.class);

    @Autowired
    private ReadService readService;

    /**
     * 读取redis
     *
     * @param key redis的键
     * @return 响应类Result
     */
    @ApiOperation(value = "解析md文档", notes = "解析md文档", produces = "application/json")
    @ApiResponses({@ApiResponse(code = 200, message = "查询成功")})
    @RequestMapping(value = "/{key}", method = RequestMethod.GET)
    public ResponseEntity<Object> lineageAnalysis(@PathVariable("key") String key) {
        LOGGER.debug("REST request to read : {}", key);
        return ResponseEntity.ok(readService.read(key));
    }
}
