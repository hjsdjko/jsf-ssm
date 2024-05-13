<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="80px"
                :style="{backgroundColor:addEditForm.addEditBoxColor}"
        >
            <el-row>
                <el-col :span="12">
                    <el-form-item class="input" v-if="type!='info'" label="会员名称" prop="hyname">
                        <el-input v-model="ruleForm.hyname"
                                  placeholder="会员名称" clearable :readonly="ro.hyname"></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="会员名称" prop="hyname">
                            <el-input v-model="ruleForm.hyname"
                                      placeholder="会员名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
				<el-col :span="12">
				    <el-form-item class="input" v-if="type!='info'" label="账号" prop="account">
				        <el-input v-model="ruleForm.account"
				                  placeholder="账号" clearable :readonly="ro.account"></el-input>
				    </el-form-item>
				    <div v-else>
				        <el-form-item class="input" label="账号" prop="account">
				            <el-input v-model="ruleForm.account"
				                      placeholder="账号" readonly></el-input>
				        </el-form-item>
				    </div>
				</el-col>
                <el-col :span="12">
                    <el-form-item class="input" v-if="type!='info'" label="密码" prop="password">
                        <el-input v-model="ruleForm.password"
                                  placeholder="密码" clearable :readonly="ro.password"></el-input>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="密码" prop="password">
                            <el-input v-model="ruleForm.password"
                                      placeholder="密码" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'" label="会员卡" prop="hykTypes">
                        <el-select v-model="ruleForm.hykTypes" placeholder="请选择会员卡类型">
                            <el-option
                                    v-for="(item,index) in hykList"
                                    v-bind:key="index"
                                    :label="item.hykname"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="会员卡" prop="hykTypes">
                            <el-input v-model="ruleForm.hykTypes"
                                      placeholder="会员卡" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="select" v-if="type!='info'" label="性别" prop="sexTypes">
						<el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
						    <el-option
						            v-for="(item,index) in sexTypesOptions"
						            v-bind:key="index"
						            :label="item"
						            :value="item">
						    </el-option>
						</el-select>
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="性别" prop="sexTypes">
                           <el-input v-model="ruleForm.sexTypes"
                                     placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12">
                    <el-form-item class="input" v-if="type!='info'" label="余额" prop="balance">
                        <el-input v-model="ruleForm.balance"
                                  placeholder="余额"></el-input>
						<!-- <span>{{ruleForm.balance}}</span>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<el-button type="primary" circle>充</el-button> -->
                    </el-form-item>
                    <div v-else>
                        <el-form-item class="input" label="余额" prop="balance">
                            <el-input v-model="ruleForm.balance" 
                                      placeholder="余额" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="24">
                    <el-form-item class="upload" v-if="type!='info' && !ro.imgPhoto" label="头像" prop="imgPhoto">
                        <file-upload
                                tip="点击上传头像"
                                action="file/upload"
                                :limit="3"
                                :multiple="true"
                                :fileUrls="ruleForm.imgPhoto?ruleForm.imgPhoto:''"
                                @change="imgPhotoUploadChange"
                        ></file-upload>
                    </el-form-item>
                    <div v-else>
                        <el-form-item v-if="ruleForm.imgPhoto" label="头像" prop="imgPhoto">
                            <img style="margin-right:20px;" v-bind:key="index"
                                 v-for="(item,index) in ruleForm.imgPhoto.split(',')" :src="item" width="100"
                                 height="100">
                        </el-form-item>
                    </div>
                </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>


    </div>
</template>
<script>
    // 数字，邮件，手机，url，身份证校验
    import {isNumber, isIntNumer, isEmail, isPhone, isMobile, isURL, checkIdCard} from "@/utils/validate";

    export default {
        data() {
            let self = this
            var validateIdCard = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!checkIdCard(value)) {
                    callback(new Error("请输入正确的身份证号码"));
                } else {
                    callback();
                }
            };
            var validateUrl = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isURL(value)) {
                    callback(new Error("请输入正确的URL地址"));
                } else {
                    callback();
                }
            };
            var validateMobile = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isMobile(value)) {
                    callback(new Error("请输入正确的手机号码"));
                } else {
                    callback();
                }
            };
            var validatePhone = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isPhone(value)) {
                    callback(new Error("请输入正确的账号号码"));
                } else {
                    callback();
                }
            };
            var validateEmail = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isEmail(value)) {
                    callback(new Error("请输入正确的邮箱地址"));
                } else {
                    callback();
                }
            };
            var validateNumber = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isNumber(value)) {
                    callback(new Error("请输入数字"));
                } else {
                    callback();
                }
            };
            var validateIntNumber = (rule, value, callback) => {
                if (!value) {
                    callback();
                } else if (!isIntNumer(value)) {
                    callback(new Error("请输入整数"));
                } else {
                    callback();
                }
            };
            return {
                addEditForm: {
                    "btnSaveFontColor": "#fff",
                    "selectFontSize": "14px",
                    "btnCancelBorderColor": "#DCDFE6",
                    "inputBorderRadius": "4px",
                    "inputFontSize": "14px",
                    "textareaBgColor": "#fff",
                    "btnSaveFontSize": "14px",
                    "textareaBorderRadius": "4px",
                    "uploadBgColor": "#fff",
                    "textareaBorderStyle": "solid",
                    "btnCancelWidth": "88px",
                    "textareaHeight": "120px",
                    "dateBgColor": "#fff",
                    "btnSaveBorderRadius": "4px",
                    "uploadLableFontSize": "14px",
                    "textareaBorderWidth": "1px",
                    "inputLableColor": "#606266",
                    "addEditBoxColor": "rgba(245, 247, 250, 1)",
                    "dateIconFontSize": "14px",
                    "btnSaveBgColor": "#409EFF",
                    "uploadIconFontColor": "#8c939d",
                    "textareaBorderColor": "#DCDFE6",
                    "btnCancelBgColor": "#ecf5ff",
                    "selectLableColor": "#606266",
                    "btnSaveBorderStyle": "solid",
                    "dateBorderWidth": "1px",
                    "dateLableFontSize": "14px",
                    "dateBorderRadius": "4px",
                    "btnCancelBorderStyle": "solid",
                    "selectLableFontSize": "14px",
                    "selectBorderStyle": "solid",
                    "selectIconFontColor": "#C0C4CC",
                    "btnCancelHeight": "44px",
                    "inputHeight": "40px",
                    "btnCancelFontColor": "#606266",
                    "dateBorderColor": "#DCDFE6",
                    "dateIconFontColor": "#C0C4CC",
                    "uploadBorderStyle": "solid",
                    "dateBorderStyle": "solid",
                    "dateLableColor": "#606266",
                    "dateFontSize": "14px",
                    "inputBorderWidth": "1px",
                    "uploadIconFontSize": "28px",
                    "selectHeight": "40px",
                    "inputFontColor": "#606266",
                    "uploadHeight": "148px",
                    "textareaLableColor": "#606266",
                    "textareaLableFontSize": "14px",
                    "btnCancelFontSize": "14px",
                    "inputBorderStyle": "solid",
                    "btnCancelBorderRadius": "4px",
                    "inputBgColor": "#fff",
                    "inputLableFontSize": "14px",
                    "uploadLableColor": "#606266",
                    "uploadBorderRadius": "4px",
                    "btnSaveHeight": "44px",
                    "selectBgColor": "#fff",
                    "btnSaveWidth": "88px",
                    "selectIconFontSize": "14px",
                    "dateHeight": "40px",
                    "selectBorderColor": "#DCDFE6",
                    "inputBorderColor": "#DCDFE6",
                    "uploadBorderColor": "#DCDFE6",
                    "textareaFontColor": "#606266",
                    "selectBorderWidth": "1px",
                    "dateFontColor": "#606266",
                    "btnCancelBorderWidth": "1px",
                    "uploadBorderWidth": "1px",
                    "textareaFontSize": "14px",
                    "selectBorderRadius": "4px",
                    "selectFontColor": "#606266",
                    "btnSaveBorderColor": "#409EFF",
                    "btnSaveBorderWidth": "1px"
                },
                id: '',
                type: '',
                ro: {
                    hyname: false,
                    password: false,
                    xingming: false,
                    hykTypes: false,
                    zhuanye: false,
                    sexTypes: false,
                    balance: false,
                    account: false,
                    youxiang: false,
                    imgPhoto: false,
                    zhuangtai: false,
                },
                ruleForm: {
                    hyname: '',
                    password: '',
                    xingming: '',
                    hykTypes: '',
                    zhuanye: '',
                    sexTypes: '',
                    balance: '',
                    account: '',
                    youxiang: '',
                    imgPhoto: '',
                    zhuangtai: '',
                },
                hykList: [],
                zhuanyeOptions: [],
                sexTypesOptions: [],
                rules: {
                    hyname: [
                        {required: true, message: '会员名称不能为空', trigger: 'blur'},
                    ],
                    password: [
                        {required: true, message: '密码不能为空', trigger: 'blur'},
                    ],
                    xingming: [
                        {required: true, message: '姓名不能为空', trigger: 'blur'},
                    ],
                    hykTypes: [],
                    zhuanye: [],
                    sexTypes: [],
                    balance: [
                        {validator: validateIntNumber, trigger: 'blur'},
                    ],
                    account: [
                        {validator: validateMobile, trigger: 'blur'},
                    ],
                    youxiang: [
                        {validator: validateEmail, trigger: 'blur'},
                    ],
                    imgPhoto: [],
                    zhuangtai: [],
                }
            };
        },
        props: ["parent"],
        computed: {},
        created() {
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
        },
        methods: {
            // 下载
            download(file) {
                window.open(`${file}`)
            },
            // 初始化
            init(id, type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if (this.type == 'info' || this.type == 'else') {
                    this.info(id);
                } else if (this.type == 'cross') {
                    var obj = this.$storage.getObj('crossObj');
                    for (var o in obj) {
                        if (o == 'hyname') {
                            this.ruleForm.hyname = obj[o];
                            this.ro.hyname = true;
                            continue;
                        }
                        if (o == 'password') {
                            this.ruleForm.password = obj[o];
                            this.ro.password = true;
                            continue;
                        }
                        if (o == 'xingming') {
                            this.ruleForm.xingming = obj[o];
                            this.ro.xingming = true;
                            continue;
                        }
                        if (o == 'hykTypes') {
                            this.ruleForm.hykTypes = obj[o];
                            this.ro.hykTypes = true;
                            continue;
                        }
                        if (o == 'zhuanye') {
                            this.ruleForm.zhuanye = obj[o];
                            this.ro.zhuanye = true;
                            continue;
                        }
                        if (o == 'sexTypes') {
                            this.ruleForm.sexTypes = obj[o];
                            this.ro.sexTypes = true;
                            continue;
                        }
                        if (o == 'balance') {
                            this.ruleForm.balance = obj[o];
                            this.ro.balance = true;
                            continue;
                        }
                        if (o == 'account') {
                            this.ruleForm.account = obj[o];
                            this.ro.account = true;
                            continue;
                        }
                        if (o == 'youxiang') {
                            this.ruleForm.youxiang = obj[o];
                            this.ro.youxiang = true;
                            continue;
                        }
                        if (o == 'imgPhoto') {
                            this.ruleForm.imgPhoto = obj[o];
                            this.ro.imgPhoto = true;
                            continue;
                        }
                        if (o == 'zhuangtai') {
                            this.ruleForm.zhuangtai = obj[o];
                            this.ro.zhuangtai = true;
                            continue;
                        }
                    }
                }
                // 获取用户信息
                this.$http({
                    url: `${this.$storage.get('sessionTable')}/session`,
                    method: "get"
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
                this.$http({
                    url: `huiyuankaleixing/page`,
                    method: "get"
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        this.hykList = data.data.list;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
                this.sexTypesOptions ="男,女".split(",")
            },
            // 多级联动参数
            info(id) {
                this.$http({
                    url: `huiyuanxinxi/info/${id}`,
                    method: "get"
                }).then(({data}) => {
                    if (data && data.code === 0) {
                        this.ruleForm = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                // ${column.compare}
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url: `huiyuanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({data}) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.huiyuanxinxiCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID() {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.huiyuanxinxiCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            imgPhotoUploadChange(fileUrls) {
                this.ruleForm.imgPhoto = fileUrls;
                this.addEditUploadStyleChange()
            },
            addEditStyleChange() {
                this.$nextTick(() => {
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el => {
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el => {
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el => {
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el => {
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el => {
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el => {
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el => {
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el => {
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el => {
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el => {
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el => {
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el => {
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el => {
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el => {
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el => {
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el => {
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
    .editor {
        height: 500px;

        & /deep/ .ql-container {
            height: 310px;
        }
    }

    .amap-wrapper {
        width: 100%;
        height: 500px;
    }

    .search-box {
        position: absolute;
    }

    .addEdit-block {
        margin: -10px;
    }

    .detail-form-content {
        padding: 12px;
    }

    .btn .el-button {
        padding: 0;
    }
</style>
