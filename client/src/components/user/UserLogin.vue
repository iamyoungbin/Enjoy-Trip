<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "@/stores/userStore.js";

const router = useRouter();

const userStore = useUserStore();
const { userLoginStore } = userStore;

const userinfo = ref({
  userId: "",
  userPwd: "",
});

const login = async () => {
  await userLoginStore(userinfo.value);
};

const findPassword = async () => {
  router.push({ name: "UserFindPassword" });
};
</script>

<template>
  <div class="wholeLayout">
    <div id="title">
      <img src="../../assets/img/logo.png" alt="" style="width: 300px; height: 300px" />
    </div>
    <label for="userId" style="width: 500px; text-align: start; font-size: 25px">아이디</label>
    <div id="id">
      <input
        type="text"
        id="userId"
        name="userId"
        placeholder="아이디를 입력해주세요."
        style="width: 500px; height: 50px; padding-left: 15px"
        v-model="userinfo.userId"
      />
    </div>
    <label for="userPwd" style="width: 500px; text-align: start; font-size: 25px">비밀번호</label>
    <div id="password">
      <input
        type="password"
        id="userPwd"
        name="userPwd"
        placeholder="비밀번호를 입력해주세요."
        style="width: 500px; height: 50px; padding-left: 15px; font-family: sans-serif"
        v-model="userinfo.userPwd"
      />
    </div>
    <div id="forgetPassword" @click="findPassword">비밀번호가 가물가물...</div>
    <div id="submitLogin">
      <input type="submit" id="btn-login" value="로그인" @click="login" />
    </div>
  </div>
</template>

<style scoped>
@font-face {
  font-family: "NanumSquare";
  src: url("../../assets/fonts/NanumSquareR.ttf") format("truetype");
}
@font-face {
  font-family: "NanumSquareB";
  src: url("../../assets/fonts/NanumSquareB.ttf") format("truetype");
}
* {
  margin: 0;
  padding: 0;
  font-family: "NanumSquare";
}
.wholeLayout {
  margin: 50px 0;
  width: 100%;
  height: 800px;
  display: flex;
  flex-direction: column;
  flex-wrap: wrap;
  align-items: center;
}
#title {
  width: 350px;
  height: 350px;
  margin: 0 0 0 50px;
}
#id {
  font-size: 20px;
  width: 500px;
  margin-bottom: 30px;
}
#password {
  font-size: 20px;
  width: 500px;
  margin-bottom: 15px;
}
#forgetPassword {
  margin-bottom: 30px;
  color: gray;
  cursor: pointer;
}
#btn-login {
  background-color: #00ae68;
  border-radius: 5px;
  width: 120px;
  height: 50px;
  transition: all 0.25s;
  box-shadow: 1px 5px 0px 0px #007144;
}
#btn-login:hover {
  box-shadow: 0px 0px 0px 0px #007144;
  margin-top: 5px;
  margin-bottom: 5px;
}
</style>
