<template>
  <div class="hello">
    <h1 v-bind="$attrs">{{ msg }},{{testPro?testPro:"null"}},{{testProByAttr}}</h1>
    <h1 v-bind="$attrs">第二个子元素</h1>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  mounted(){
    this.testProByAttr = this.$el.getAttribute("testPro")
  },
  data(){
    return {
      testProByAttr:null
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
