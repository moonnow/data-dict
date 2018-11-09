<style lang="less">
  @import './dataDict-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="dataDictForm" :model="dataDict" :rules="dataDictFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="数据字典名称：" prop="dataDictName">
              <Input v-model="dataDict.dataDictName" placeholder="输入数据字典名称"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="数据字典标识：" prop="dataDictKey">
              <Input v-model="dataDict.dataDictKey" placeholder="输入数据字典标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="描述：" prop="description">
              <Input v-model="dataDict.description" placeholder="输入描述"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem>
              <Button class="margin-right-8" @click="gotoList()">取消</Button>
              <Button class="margin-right-8" @click="reset()">重置</Button>
              <Button class="margin-right-8" type="primary" @click="saveAdd()" :loading="submitting">保存并继续录入</Button>
              <Button class="margin-right-8" type="primary" @click="save()" :loading="submitting">保存</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import DataDict from '@/view/com/pro/data/dict/dataDict/dataDict'

export default {
  name: 'DataDictEdit',
  props: {
  },
  data () {
    return {
      dataDict: new DataDict(),
      dataDictFormValidate: {
        dataDictName: [
          { required: true, message: '数据字典名称不能为空', trigger: 'blur' }
        ],
        dataDictKey: [
          { required: true, message: '数据字典标识不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
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
      'saveDataDict',
      'updateDataDict',
      'getDataDictByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'dataDict-list' })
    },
    reset () {
      this.$refs.dataDictForm.resetFields()
    },
    saveAdd () {
      this.continue = true
      this.submit()
    },
    save () {
      this.continue = false
      this.submit()
    },
    submit () {
      this.submitting = true
      this.$refs.dataDictForm.validate((valid) => {
        if (valid) {
          if (this.dataDict.dataDictId !== 'add') {
            this.updateDataDict(this.dataDict).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.dataDict = new DataDict()
                this.dataDict.dataDictId = 'add'
                this.submitting = false
                if (!this.continue) {
                  this.gotoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                this.submitting = false
              }
            }).catch(result => {
              this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
              this.submitting = false
            })
          } else {
            this.saveDataDict(this.dataDict).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据字典信息保存成功.', duration: 3 })
                this.reset()
                this.dataDict = new DataDict()
                this.dataDict.dataDictId = 'add'
                this.submitting = false
                if (!this.continue) {
                  this.gotoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                this.submitting = false
              }
            }).catch(result => {
              this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
              this.submitting = false
            })
          }
        } else {
          setTimeout(() => { this.submitting = false }, 3000)
        }
      })
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
