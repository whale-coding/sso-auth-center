<template>
  <div class="sidebar-logo-container" :class="{'collapse':collapse}">
    <transition name="sidebarLogoFade">
      <router-link v-if="collapse" key="collapse" class="sidebar-logo-link" @click.native="clickLogo">
        <img v-if="logo" :src="logo" class="sidebar-logo">
      </router-link>
      <router-link v-else key="expand" class="sidebar-logo-link" to="#" @click.native="clickLogo">
        <img v-if="logo" :src="logo"  class="sidebar-logo">
      </router-link>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'Logo',
  props: {
    collapse: {
      type: Boolean,
      required: true
    }
  },
  data() {
    return {
      title: '',
      logo: require('@/assets/logo/logo.png')
    }
  },
  methods: {
    clickLogo() {
      //点击logo 跳转到首页 
      this.$router.push("/")
    }
  }
}
</script>

<style lang="scss" scoped>
.sidebarLogoFade-enter-active {
  transition: opacity 1.5s;
}

.sidebarLogoFade-enter,
.sidebarLogoFade-leave-to {
  opacity: 0;
}

.sidebar-logo-container {
  position: relative;
  width: 100%;
  height: 60px;
  line-height: 50px;
  background: #2b2f3a;
  text-align: center;
  overflow: hidden;

  & .sidebar-logo-link {
    height: 100%;
    width: 100%;

    & .sidebar-logo {
      width: 59px;
      height: 59px;
      vertical-align: middle;
      margin-right: 12px;
    }

    // & .sidebar-logo {
    //   width: 32px;
    //   height: 32px;
    //   vertical-align: middle;
    //   margin-right: 12px;
    // }

    & .sidebar-title {
      display: inline-block;
      margin: 0;
      color: #fff;
      font-weight: 600;
      line-height: 50px;
      font-size: 14px;
      font-family: Avenir, Helvetica Neue, Arial, Helvetica, sans-serif;
      vertical-align: middle;
    }
  }

  &.collapse {
    .sidebar-logo {
      margin-right: 0px;
    }
  }
}
</style>
