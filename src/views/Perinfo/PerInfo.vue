<template>
  <div class="Perinfo">
    <person-info></person-info>
    <div><el-button>修改个人信息</el-button></div>
    <el-divider border-style="dashed" />
    <div class="per-order">
      <div class="o-wrap">
        <div class="o-title">我的订单</div>

        <div class="info-table">
          <table class="table-info">
            <thead>
              <tr class="head">
                <th class="head-item">序号</th>
                <th class="head-item">商品名称</th>
                <th class="head-item">支付时间</th>
                <th class="head-item">支付金额</th>
                <th class="head-item">商品状态</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="(item, index) in data0" :key="index" class="info">
                <td class="info-item">{{ index + 1 }}</td>
                <td class="info-item">{{ item.name }}</td>
                <td class="info-item">{{ item.age }}</td>
                <td class="info-item">{{ item.age }}</td>
                <td class="info-item">{{ item.age }}</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getUser } from "@/api/user";
import PersonInfo from "./childcomponents/PersonInfo.vue";
export default {
  components: {
    PersonInfo,
  },
  props: {
    data0: {
      type: Array,
      default: [
        { name: "aaa", age: 19, sex: "m" },
        {
          name: "nnn",
          age: 90,
          sex: "w",
        },
      ],
    },
  },
  created() {
    this.getUserData = getUser().then((res) => {
      if (res.data.message == "登录信息无效，请重新登录") {
        this.$router.push("/login");
      } else {
        console.log(res.data.data);
        this.getUserData = res.data.data;
      }
    });
  },
  data() {
    return {
      getUserData: {},
    };
  },
};
</script>

<style>
.Perinfo {
  padding: 3vw;
}
.per-order {
  display: flex;
  flex-direction: column;
}
.o-wrap {
  font-size: large;
}
.info-table {
  width: 100%;
  padding: 1vw 0;
  display: flex;
  flex-direction: column;
}
.table-info {
  width: 100%;
  border: 0.5px solid rgba(0, 0, 0, 0.3);
  border-collapse: collapse; /*让边框融合*/
  /* border-spacing: 10px; 指定边框之间的距离 */
}
.head {
  background-color: #cccacc;
  color: #333;
  font-weight: 700;
  height: 4vw;
}
.table-info td {
  height: 3vw;
  border: 0.5px solid #cccacc;
  vertical-align: middle;
  /* text-align: left; */
  /* 默认情况下元素在td中是垂直居中的 可以通过vertical 和text调整 */
}
</style>
