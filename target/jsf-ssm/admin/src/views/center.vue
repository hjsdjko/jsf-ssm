<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
    >  
     <el-row>
		  <el-col :span="12">
			<el-form-item   v-if="flag=='shiyansliebiao'"  label="账号" prop="account">
			  <el-input v-model="ruleForm.account"               placeholder="账号" clearable></el-input>
			</el-form-item>
			<el-form-item   v-if="flag=='users'"  label="账号" prop="username">
			  <el-input v-model="ruleForm.username"               placeholder="账号" clearable></el-input>
			</el-form-item>
		  </el-col>
		  <el-col :span="12">
		   <el-form-item>
			 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
		   </el-form-item>
		  </el-col>	
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
	  shiyanshimingcheng:'',
                                                                                                                                        };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
	
    },
  methods: {
                                                                                                                                                                                                                                                                                xueshengzhaopianUploadChange(fileUrls) {
        this.ruleForm.zhaopian = fileUrls;
    },
                                                                                                    onUpdateHandler() {
                              if((!this.ruleForm.xuehao)&& 'xuesheng'==this.flag){
        this.$message.error('学号不能为空');
        return
      }
                                                            if((!this.ruleForm.mima)&& 'xuesheng'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
                                                            if((!this.ruleForm.xingming)&& 'xuesheng'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
                                                                                                                                                                                                                  if( 'xuesheng' ==this.flag && this.ruleForm.nianling&&(!isIntNumer(this.ruleForm.nianling))){
       this.$message.error(`年龄应输入整数`);
        return
      }
                                                                                                                              if( 'xuesheng' ==this.flag && this.ruleForm.youxiang&&(!isEmail(this.ruleForm.youxiang))){
        this.$message.error(`邮箱应输入邮箱格式`);
        return
      }
                                                                                                                                                                                                                                                      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
