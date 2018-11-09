<style lang="less">
  @import './dataDict-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>数据字典编号：{{ dataDict.dataDictId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>数据字典名称：{{ dataDict.dataDictName }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>数据字典标识：{{ dataDict.dataDictKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>描述：{{ dataDict.description }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import DataDict from '@/view/com/pro/data/dict/dataDict/dataDict'

export default {
  name: 'DataDictDetail',
  props: {
  },
  data () {
    return {
      dataDict: new DataDict()
    }
  },
  computed: {
    ...mapState('dataDictStore', [
    ]),
    ...mapGetters('dataDictStore', [
    ])
  },
  methods: {
    ...mapMutations('dataDictStore', [
    ]),
    ...mapActions('dataDictStore', [
      'getDataDictByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'dataDict-list' })
    }
  },
  created () {
    this.dataDict.dataDictId = this.$route.params.dataDictId
    if (this.dataDict.dataDictId !== 'add') {
      this.getDataDictByPk(this.dataDict.dataDictId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.dataDict, res.data.data[0])
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
