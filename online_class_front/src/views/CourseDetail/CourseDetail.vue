<template>
  <div>
    <!-- 顶部返回组件 -->
    <detail-header :videoInfo="videoInfo"></detail-header>

    <!-- 视频介绍组件 -->
    <detail-course :videoInfo="videoInfo"></detail-course>

    <!-- 视频tab简介 -->
    <detail-tab :videoInfo="videoInfo" :chapterList="chapterList"></detail-tab>

    <!-- 底部立刻购买 -->
    <footer>
      <router-link
        :to="{ path: '/pay', query: { video_id: this.$route.query.video_id } }"
      >
        <button>立刻购买</button>
      </router-link>
    </footer>
  </div>
</template>

<script>
//引入组件
import DetailHeader from "./Component/Header";
import DetailCourse from "./Component/Course";
import DetailTab from "./Component/Tab";

import { getVideoDetail } from "@/api/getData";
export default {
  //注册组件
  components: {
    DetailHeader,
    DetailCourse,
    DetailTab,
  },
  data() {
    return {
      //视频信息
      videoInfo: {},
      //章集
      chapterList: [],
    };
  },

  methods: {
    //获取视频详情
    async getDetail(vid) {
      try {
        const result = await getVideoDetail(vid);
        if (result.data.code == 0) {
          this.videoInfo = result.data.data;
          this.chapterList = result.data.data.chapter_list;
        }
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    //渲染完成后拿数据
    this.getDetail(this.$route.query.video_id);
  },
};
</script>

<style lang="scss" scoped>
//底部
footer {
  // fixed固定在底部
  position: fixed;
  bottom: 0;
  width: 100%;
  padding: 8px 0;
  background-color: #fff;
  z-index: 999;
  box-shadow: 0 -2px 4px 0 rgba(0, 0, 0, 0.05);
}
//设置购买按钮样式
button {
  display: block;
  color: #fff;
  margin: 0 auto;
  background-color: #d93f30;
  height: 34px;
  line-height: 34px;
  border-radius: 17px;
  width: 80%;
  border: none;
  font-size: 15px;
  text-align: center;
}
</style>
