<template>
    <div>
        <MenuCard></MenuCard>
    </div>
</template>

<script>
import MenuCard from '@/components/MenuCard.vue'

export default {
    name: 'MenuView',
    props: {
        msg: String
    },
    components:{
        MenuCard,
    },
}
</script>

<style lang="scss" scoped></style>