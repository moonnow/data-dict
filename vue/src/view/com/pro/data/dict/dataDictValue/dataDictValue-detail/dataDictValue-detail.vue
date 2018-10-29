<style lang="less">
  @import './dataDictValue-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>数据字典值编号：{{ dataDictValue.dataDictValueId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>代码：{{ dataDictValue.code }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>显示名称：{{ dataDictValue.displayName }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>数据字典编号：{{ dataDictValue.dataDictId }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import DataDictValue from '@/view/com/pro/data/dict/dataDictValue/dataDictValue'

export default {
  name: 'DataDictValueDetail',
  props: {
  },
  data () {
    return {
      dataDictValue: new DataDictValue()
    }
  },
  computed: {
    ...mapState('dataDictValueStore', [
    ]),
    ...mapGetters('dataDictValueStore', [
    ])
  },
  methods: {
    ...mapMutations('dataDictValueStore', [
    ]),
    ...mapActions('dataDictValueStore', [
      'getDataDictValueByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'dataDictValue-list' })
    }
  },
  created () {
    this.dataDictValue.dataDictValueId = this.$route.params.dataDictValueId
    if (this.dataDictValue.dataDictValueId !== 'add') {
      this.getDataDictValueByPk(this.dataDictValue.dataDictValueId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.dataDictValue, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
      })
    }
  }
}
</script>
