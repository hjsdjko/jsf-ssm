const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "会员账号列表",
                    "menuJump": "列表",
                    "tableName": "huiyuanxinxi"
                }],
                "menu": "账号管理"
            }, {
                "child": [{
                        "buttons": ["新增", "查看", "修改", "删除"],
                        "menu": "健身房列表",
                        "menuJump": "列表",
                        "tableName": "jianshenfangxinxi"
                }],
                "menu": "健身房信息管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "教练信息",
                    "menuJump": "列表",
                    "tableName": "jiaolianxinxi"
                }],
                "menu": "教练管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "健身器材信息",
                    "menuJump": "列表",
                    "tableName": "jianshenqicaixinxi"
                }],
                "menu": "健身器材管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "普通课程信息",
                    "menuJump": "列表",
                    "tableName": "kechengxinxi"
                }, {
				    "buttons": ["新增", "查看", "修改", "删除","预约"],
				    "menu": "私教课程信息",
				    "menuJump": "列表",
				    "tableName": "sijiaokechengxinxi"
				}, {
				    "buttons": ["新增", "查看", "修改", "删除"],
				    "menu": "预约私教课程信息",
				    "menuJump": "列表",
				    "tableName": "yuykechengxinxi"
				}],
                "menu": "课程管理"
            }, {
                "child": [ {
				    "buttons": ["新增", "查看", "修改", "删除"],
				    "menu": "会员卡类型",
				    "menuJump": "列表",
				    "tableName": "huiyuankaleixing"
				}],
                "menu": "会员卡管理"
            }],
            "frontMenu": [],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        },
		{
            "backMenu": [{
                "child": [{
                        "buttons": ["查看"],
                        "menu": "健身房列表",
                        "menuJump": "列表",
                        "tableName": "jianshenfangxinxi"
                }],
                "menu": "健身房信息管理"
            }, {
                "child": [{
                    "buttons": ["查看", "修改"],
                    "menu": "教练信息",
                    "menuJump": "列表",
                    "tableName": "jiaolianxinxi"
                }],
                "menu": "教练管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "健身器材信息",
                    "menuJump": "列表",
                    "tableName": "jianshenqicaixinxi"
                }],
                "menu": "健身器材管理"
            }, {
                "child": [{
                    "buttons": ["查看"],
                    "menu": "普通课程信息",
                    "menuJump": "列表",
                    "tableName": "kechengxinxi"
                }, {
				    "buttons": ["查看"],
				    "menu": "私教课程信息",
				    "menuJump": "列表",
				    "tableName": "sijiaokechengxinxi"
				}],
				 "menu": "课程管理",
			}],
            "frontMenu": [],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "教练",
            "tableName": "jiaolianxinxi"
        },
		{
		    "backMenu": [{
				"child": [{
                    "buttons": ["查看", "修改"],
                    "menu": "会员账号列表",
                    "menuJump": "列表",
                    "tableName": "huiyuanxinxi"
                }],
                "menu": "账号管理"
            }, {
		        "child": [{
		                "buttons": ["查看"],
		                "menu": "健身房列表",
		                "menuJump": "列表",
		                "tableName": "jianshenfangxinxi"
		        }],
		        "menu": "健身房信息管理"
		    }, {
		        "child": [{
		            "buttons": ["查看"],
		            "menu": "普通课程信息",
		            "menuJump": "列表",
		            "tableName": "kechengxinxi"
		        }, {
				    "buttons": ["查看","预约"],
				    "menu": "私教课程信息",
				    "menuJump": "列表",
				    "tableName": "sijiaokechengxinxi"
				}, {
				    "buttons": ["查看","删除"],
				    "menu": "预约私教课程信息",
				    "menuJump": "列表",
				    "tableName": "yuykechengxinxi"
				}],
				 "menu": "课程管理",
			}],
		    "frontMenu": [],
		    "hasBackLogin": "是",
		    "hasBackRegister": "否",
		    "hasFrontLogin": "否",
		    "hasFrontRegister": "否",
		    "roleName": "会员",
		    "tableName": "huiyuanxinxi"
		},
		{
		    "backMenu": [{
		        "child": [{
		                "buttons": ["查看"],
		                "menu": "健身房列表",
		                "menuJump": "列表",
		                "tableName": "jianshenfangxinxi"
		        }],
		        "menu": "健身房信息管理"
		    }, {
		        "child": [{
		            "buttons": ["查看"],
		            "menu": "普通课程信息",
		            "menuJump": "列表",
		            "tableName": "kechengxinxi"
		        }, {
				    "buttons": ["查看"],
				    "menu": "私教课程信息",
				    "menuJump": "列表",
				    "tableName": "sijiaokechengxinxi"
				}],
				 "menu": "课程管理",
			}],
		    "frontMenu": [],
		    "hasBackLogin": "是",
		    "hasBackRegister": "否",
		    "hasFrontLogin": "否",
		    "hasFrontRegister": "否",
		    "roleName": "访客",
		    "tableName": "users"
		},
	]}
}
export default menu;
