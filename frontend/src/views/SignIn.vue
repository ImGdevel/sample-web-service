<template>
    <main>
        <div class="login-box">
            <div id="loginBoxTitle">Sign In</div>
            <form @submit.prevent="handleSignIn">
                <div class="form-group">
                    <label for="uid">Email</label>
                    <input type="text" v-model="username" name="uid" id="uid" class="form-control" value=""
                        style="text-transform: uppercase; ime-mode: disabled" required>
                </div>
                <div class="form-group">
                    <label for="upw">Password</label>
                    <div class="password-input">
                        <input type="password" v-model="password" name="upw" id="upw" class="form-control" value=""
                            autocomplete="off" required>
                        <span class="toggle-password" @click="togglePasswordVisibility"></span>
                    </div>
                </div>
                <div id="login-btn-box">
                    <div>
                        <label class="form-check-label" for="checkboxNoLabel">remember me </label>
                        <input class="form-check-input" type="checkbox" id="checkboxNoLabel" value="" aria-label="...">
                    </div>
                    <input type="submit" id="btnLogin" value="로그인" class="btn btn-danger" :disabled="loading">
                </div>
            </form>
        </div>
    </main>
</template>
  
<script>
export default {
    data() {
        return {
            username: '',
            password: '',
            loading: false,
        };
    },
    methods: {
        async handleSignIn() {
            try {
                this.loading = true;
                const response = await this.$axios.post('/api/signin', {
                    username: this.username,
                    password: this.password,
                });
                
                console.log('Sign In successful:', response.data);
            } catch (error) {
                console.error('Sign In failed:', error.response.data);
            } finally {
            this.loading = false;
        }
        },
    },
};
</script>
  
<style>
body {
    background-size: 100%;
    font-size: 0.75rem;
}

#loginBoxTitle {
    color: #000000;
    font-weight: bold;
    font-size: 1.9rem;
    padding: 5px;
    margin-bottom: 20px;
    background: linear-gradient(to right, #270a09, #8ca6ce);
    background-clip: text;
    -webkit-text-fill-color: transparent;
}

input[type="button"] {
    font-size: 0.75rem;
    padding: 5px 10px;
}

.login-box {
    margin: 150px auto;
    background-color: rgba(255, 255, 255, 1);
    border-radius: 10px;
    padding: 40px 30px;
    border: 5px solid #0e0e0e;
    width: 350px;
    filter: drop-shadow(0px 0px 10px rgba(0, 0, 0, .5));
    transition: border-color 0.3s ease-in-out;
}

.form-group label {
    font-size: 0.75rem;
    margin: 5px 0;
}

.login-box:hover {
    border-color: #1a1a1a;
}


#login-btn-box {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 10px;
}</style>