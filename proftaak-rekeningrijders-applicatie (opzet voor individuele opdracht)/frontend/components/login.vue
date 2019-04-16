<template>
    <div>
        <p>Login</p>
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        data() {
            return {
                form: {
                    email: null,
                    password: null
                }
            }
        },
        methods: {
            login(){
                axios.post('', this.form).then(({data}) => {


                }).catch(() => {
                    alert('Login is onjuist.');
                })
            }
        }
    }
</script>