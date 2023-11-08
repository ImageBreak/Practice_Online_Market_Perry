<template>
  <div class="cata_box">
    <div>
      <ul class="content" v-for="(item, index) in chapterList" :key="item.id">
        <h1>第{{ index + 1 }}章 &nbsp; {{ item.title }}</h1>
        <li
          class="sub_cata"
          v-for="(item, sub_index) in chapterList[index].episode_list"
          :key="item.id"
        >
          <span class="sub_title">
            {{ index + 1 }}-{{ sub_index + 1 }} &nbsp; {{ item.title }}
          </span>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  //从父组件获取章集信息
  props: {
    chapterList: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style lang="scss" scoped>
// ⽬录包裹层设置边距
.cata_box {
  padding: 0 15px 50px;
  background-color: #fff;
  margin: 15px 0;
}
//每⼀章包裹层

.content {
  padding: 10px;
  // 章标题
  & h1 {
    font-size: 16px;
    width: 100%;
    margin-bottom: 15px;
    font-weight: bolder;
    // 设置章标题过⻓,超过⾏宽度省略隐藏
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}
//集包裹层
.sub_cata {
  font-size: 12px;
  padding: 10px 0;
  //集标题
  .sub_title {
    // 设置集标题过⻓,超过⾏宽度省略隐藏
    display: block;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}
</style>
