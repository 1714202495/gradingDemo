package com.skytech.grading.business.controller;

import com.skytech.grading.business.domain.Evidence;
import com.skytech.grading.business.service.EvidenceService;
import com.skytech.grading.business.util.PageHelper;
import com.skytech.grading.config.util.JWTUtil;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class EvidenceController {

    @Autowired
    private EvidenceService evidenceService;

    //获取证明材料信息
    @RequestMapping(value = "/evidence/list")
    @RequiresPermissions(value = "queryEvidence")
    public PageHelper getEvidenceList(PageHelper pageHelper) throws Exception {
        PageHelper evidenceList = evidenceService.getEvidenceList(pageHelper);
        return evidenceList;
    }

    @RequestMapping(value = "/api/uploadEvidence" ,method = RequestMethod.POST)
    public boolean uploadEvidence(MultipartFile file, HttpServletRequest request){
        Evidence evidence = new Evidence();
        /*解析token*/
        String token = request.getHeader("Authorization");
        //检查jwt令牌, 如果令牌不合法或者过期, 里面会直接抛出异常, 下面的catch部分会直接返回
        Map<String, Object> body = Jwts.parser()
                .setSigningKey("ThisIsASecret")
                .parseClaimsJws(token.replace("Bearer ",""))
                .getBody();
        String userid = (String)body.get("username");

        /*解析token*/
        return evidenceService.uploadEvidence(file,evidence,userid);
    }

    @RequestMapping("/api/delEvidence")
    public int delEvidence(Evidence evidence){
        return evidenceService.delEvidence(evidence);
    }
}
