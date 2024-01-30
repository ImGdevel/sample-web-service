<template>
    <div>
        <h2>Sign Up</h2>
        <form @submit.prevent="handleSignUp">
            <label for="username">Username:</label>
            <input type="text" v-model="username" required>
            <br>
            <label for="password">Password:</label>
            <input type="password" v-model="password" required>
            <br>
            <button type="submit">Sign Up</button>
        </form>
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            password: '',
        };
    },
    methods: {
        async handleSignUp() {
            try {
                const response = await this.$axios.post('/api/signup', {
                    username: this.username,
                    password: this.password,
                });

                console.log('Sign Up successful:', response.data);
            } catch (error) {
                console.error('Sign Up failed:', error.response.data);
            }
        },
    },
};
</script>
