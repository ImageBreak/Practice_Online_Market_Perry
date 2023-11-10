package net.perry.online_class.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.perry.online_class.model.entity.VideoOrder;
import net.perry.online_class.model.request.VideoOrderRequest;
import net.perry.online_class.service.VideoOrderService;
import net.perry.online_class.utils.JsonData;

@RestController
@RequestMapping("api/v1/pri/order")
public class VideoOrderController {

    @Autowired
    private VideoOrderService videoOrderService;
    
    /**
     * 下单接口
     * @return
     */
    @RequestMapping("save")
    public JsonData saveOrder(@RequestBody VideoOrderRequest videoOrderRequest, HttpServletRequest request){

        Integer userId = (Integer) request.getAttribute("user_id");
        
        int rows = videoOrderService.save(userId, videoOrderRequest.getVideoId());

        return rows == 0 ? JsonData.buildError("下单失败") : JsonData.buildSuccess();
    }

    /**
     * 列出订单列表
     * @param requestï
     * @return
     */
    @RequestMapping("list")
    public JsonData listOrder(HttpServletRequest request){
        
        Integer userId = (Integer) request.getAttribute("user_id");

        List<VideoOrder> videoOrderList = videoOrderService.listOrderByUserId(userId);

        return JsonData.buildSuccess(videoOrderList);
    }
}
