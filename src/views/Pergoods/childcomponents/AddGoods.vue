<template>
  <div class="addgoods">
    <Upload
      ref="upload"
      :show-upload-list="false"
      :default-file-list="defaultList"
      :on-success="handleSuccess"
      :format="['jpg', 'jpeg', 'png']"
      :max-size="2048"
      :on-format-error="handleFormatError"
      :on-exceeded-size="handleMaxSize"
      :before-upload="handleBeforeUpload"
      multiple
      type="drag"
      action="//jsonplaceholder.typicode.com/posts/"
      style="display: inline-block; width: 58px"
    >
      <div style="width: 58px; height: 58px; line-height: 58px">
        <Icon type="ios-camera" size="20"></Icon>
      </div>
    </Upload>
    <ImagePreview
      v-model="visible"
      :preview-list="['https://file.iviewui.com/images/' + imgName]"
    />

    <div class="name-money">
      <div class="goodsname">
        <Input
          v-model="value"
          placeholder="Enter something..."
          style="width: 300px"
        />
      </div>
      <div class="goodsmoney">
        <Poptip trigger="focus">
          <Input
            v-model="value"
            prefix="logo-usd"
            placeholder="Enter number"
            style="width: 200px"
          />
          <template #content>
            <div>{{ formatNumber }}</div>
          </template>
        </Poptip>
      </div>
    </div>

    <div class="goodsinfo">
      <Input
        v-model="value2"
        maxlength="100"
        show-word-limit="true"
        type="textarea"
        placeholder="商品描述"
        style="width: 100%"
      />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      value2: "",
    };
  },
  methods: {
    handleView(name) {
      this.imgName = name;
      this.visible = true;
    },
    handleRemove(file) {
      const fileList = this.$refs.upload.fileList;
      this.$refs.upload.fileList.splice(fileList.indexOf(file), 1);
    },
    handleSuccess(res, file) {
      file.url = "https://file.iviewui.com/images/image-demo-3.jpg";
      file.name = "image-demo-3.jpg";
    },
    handleFormatError(file) {
      this.$Notice.warning({
        title: "The file format is incorrect",
        desc:
          "File format of " +
          file.name +
          " is incorrect, please select jpg or png.",
      });
    },
    handleMaxSize(file) {
      this.$Notice.warning({
        title: "Exceeding file size limit",
        desc: "File  " + file.name + " is too large, no more than 2M.",
      });
    },
    handleBeforeUpload() {
      const check = this.uploadList.length < 5;
      if (!check) {
        this.$Notice.warning({
          title: "Up to five pictures can be uploaded.",
        });
      }
      return check;
    },
  },
};
</script>

<style>
.addgoods {
  /* background-color: aqua; */
  width: 80vw;
  height: 20vw;
  display: flex;
  justify-content: space-around;
  flex-direction: column;
}
.name-money {
  display: flex;
  width: 100%;
  /* justify-content: space-around; */
}
.goodsname {
  margin-right: 2vw;
}
.goodsinfo {
}
</style>
