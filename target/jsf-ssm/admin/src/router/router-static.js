import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import center from '@/views/center'
import register from '@/views/register'



import huiyuankaleixing from '@/views/modules/huiyuankaleixing/list'
import yuykechengxinxi from '@/views/modules/yuykechengxinxi/list'
import sijiaokechengxinxi from '@/views/modules/sijiaokechengxinxi/list'
import kechengxinxi from '@/views/modules/kechengxinxi/list'
import jiaolianxinxi from '@/views/modules/jiaolianxinxi/list'
import jianshenqicaixinxi from '@/views/modules/jianshenqicaixinxi/list'
import huiyuanxinxi from '@/views/modules/huiyuanxinxi/list'
import jianshenfangxinxi from '@/views/modules/jianshenfangxinxi/list'



//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
	  path: '/jianshenfangxinxi',
	  name: '健身房信息',
	  component: jianshenfangxinxi
    }, {
	  path: '/huiyuanxinxi',
	  name: '会员账号列表',
	  component: huiyuanxinxi
	}, {
	  path: '/jiaolianxinxi',
	  name: '教练信息',
	  component: jiaolianxinxi
    }, {
	  path: '/jianshenqicaixinxi',
	  name: '健身器材信息',
	  component: jianshenqicaixinxi
	}, {
	  path: '/kechengxinxi',
	  name: '普通课程信息',
	  component: kechengxinxi
	}, {
	  path: '/sijiaokechengxinxi',
	  name: '私教课程信息',
	  component: sijiaokechengxinxi
	}, {
	  path: '/yuykechengxinxi',
	  name: '预约私教课程信息',
	  component: yuykechengxinxi
	}, {
	  path: '/huiyuankaleixing',
	  name: '会员卡类型信息',
	  component: huiyuankaleixing
	}
   ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
