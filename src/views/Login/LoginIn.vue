<template>
 <div class="Login"> 
    <div class="login-wrap">
    <Tabs type="card" id="card">
        <TabPane label="登录">
            <div class="demo-login" style="padding: 5vw 10vw;">
            <Login @on-submit="handleSubmit1">
            <UserName name="username" />
            <Password name="password"/>
            <Submit />
            </Login>
             </div>
        </TabPane>
        <TabPane label="快捷注册">
            <div class="demo-register" style="padding:5vw 5vw;">
            <Login ref="form" @on-submit="handleSubmit2">
                <UserName name="username0" /> 
               <!-- <Poptip trigger="focus" placement="right" width="240"> --> 
                <Password name="password0" :rules="passwordRule" placeholder="至少6位密码，区分大小写" @on-change="handleChangePassword" />
                <!-- </Poptip> -->
                <Password name="passwordConfirm" :rules="passwordConfirmRule" placeholder="确认密码" />
                <Submit>快捷注册</Submit>
        </Login>
    </div>
        </TabPane>
        <TabPane label="注册">
            <div class="demo-login" style="padding:0vw 5vw;">
           <Login @on-submit="handleSubmit3">
            <UserName name="username1" /> 
            <Password name="password1" :rules="passwordRule" placeholder="至少6位密码，区分大小写" @on-change="handleChangePassword" />
            <Password name="passwordConfirm1" :rules="passwordConfirmRule" placeholder="确认密码" />
            <Email name="mail" />
            <Captcha name="captcha" :field="['mail']" @on-get-captcha="handleGetCaptcha" />
            <Submit>注册</Submit>
        </Login>
    </div>
        </TabPane>
    </Tabs>
</div>
    <!--<div class="demo-login">
        <Login @on-submit="handleSubmit">
            <Mobile name="mobile" />
            <Captcha name="captcha" :field="['mobile']" @on-get-captcha="handleGetCaptcha" />
            <Submit />
        </Login>
    </div> -->
  </div>
</template>

<script>
import { login ,mailregister,register1,register0 } from '@/api/user';

export default {
    data () {
            const validatePassCheck = (rule, value, callback) => {
                if (value !== this.$refs.form.formValidate.password) {
                    callback(new Error('两次输入的密码不匹配！'));
                } else {
                    callback();
                }
            };

            return {

                token:'',
                passwordRule: [
                    {
                        required: true, message: '密码不能为空！', trigger: 'change'
                    },
                    {
                        min: 6, message: '密码不能少于6位！', trigger: 'change'
                    }
                ],
                passwordConfirmRule: [
                    {
                        required: true, message: '确认密码不能为空！', trigger: 'change'
                    },
                    { validator: validatePassCheck, trigger: 'change' }
                ],
                // 密码长度，在密码强度提示时作为判断依据
                passwordLen: 0
            }
        },
        methods: {
            handleChangePassword (val) {
                this.passwordLen = val.length;
            },
        
            async handleSubmit1 (valid, { username, password }) {
                if (valid) {
                const form ={
                    username:username,
                    password:password
                }
                console.log(form)
                const {data} = await login(form)
                if(data.code==200){
                    this.token=data.data.token
                    this.$store.commit("changeLogin",{Authorization:this.token});
                    console.log(this.$store.state.Authorization)
                    alert("登录成功！")

                    this.$router.push('/home')

                }
                else if(data.code == 201){
                    alert("账号或者密码错误！")
                    username=''
                    password=''
                }      
                }
            }
            ,
            async handleSubmit2 (valid, { username0, password0 }){
                 if(valid){
                    const form0={
                        username:username0,
                        password:password0
                    }
                    console.log(form0)
                    const data=await register0(form0)
                    if(data.code==200){
                        console.log("注册成功")
                        this.token=data.data.token
                        this.$store.commit("changeLogin",{Authorization:this.token});
                        console.log(this.$store.state.Authorization)
                        this.$router.push('/home')
                    }
                    else{
                        console.log("注册失败")
                        username0=''
                        password0=''
                    }
                 }
            },
            async handleGetCaptcha(mail){
           
                    const {data} =await mailregister(mail)
                    if(data.code==200){
                        console.log("验证码发送成功！")
                    }
                    else if(data.code==201){
                        console.log("该用户已注册过，请直接登录！")
                        mail=''
                    }
                    else{
                        console.log("验证码发送失败！")
                        mail=''
                    }
                 
            },
            async handleSubmit3 (valid, {username1,password1,mail,captcha}) {
                if (valid) {
                        const form1={
                            captcha:captcha,
                            username:username1,
                            password:password1,
                            mail:mail
                        }
                      const{data} =await register1(form1)
                      if(data==200){
                          console.log("注册成功！")
                          this.token=data.data.token
                          this.$store.commit("changeLogin",{Authorization:this.token});
                         console.log(this.$store.state.Authorization)
                          this.$router.push('/home')
                      }
                      else{
                        console.log("注册失败！")
                        username1=''
                        password1=''
                        mail=''
                      }
                    
                }
            },


        }
    
}
</script>

<style>
.Login{
    background-image: url('@/assets/img/manager_login.png');
}
.login-wrap{
    padding:10% 25%;
}
#card{
    background-color: #fff;
    padding:20px;
    /* padding-top:110px; */
    border-radius: 3%;
 box-shadow: 2px 2px 5px ;
}
</style>