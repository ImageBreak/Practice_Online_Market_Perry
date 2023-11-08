<template>
  <div>
    <home-banner :banners = "banners"> </home-banner>
    <video-list :videoList = "videoList"></video-list>
    <common-footer></common-footer>
  </div>
</template>

<script>
import HomeBanner from "./Component/Banner";
import VideoList from "./Component/VideoList";
import CommonFooter from "@/components/CommonFooter";
import { getBanner, getVideoList } from "@/api/getData.js";

export default {
  //注册组件
  components: {
    HomeBanner,
    VideoList,
    CommonFooter,
  },
  //声明数据源
  data() {
    return {
      banners: [],
      videoList: [],
    };
  },
  //定义方法
  methods: {
    //获取轮播图数据
    async getBannerData() {
      try {
        const result = await getBanner();
        console.log(result);
        if (result.data.code == 0) {
          this.banners = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },

    //获取视频列表
    async getVideoListData() {
      try {
        const result = await getVideoList();
        console.log(result);
        if (result.data.code == 0) {
          this.videoList = result.data.data;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    //页面渲染完成调用方法获取数据
    this.getBannerData();
    this.getVideoListData();
  },
};
</script>

<style lang="scss" scope></style>
