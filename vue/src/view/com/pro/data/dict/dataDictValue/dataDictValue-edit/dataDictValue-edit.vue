<style lang="less">
  @import './dataDictValue-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="dataDictValueForm" :model="dataDictValue" :rules="dataDictValueFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="代码：" prop="code">
              <Input v-model="dataDictValue.code" placeholder="输入代码"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="显示名称：" prop="displayName">
              <Input v-model="dataDictValue.displayName" placeholder="输入显示名称"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="数据字典编号：" prop="dataDictId">
              <Input v-model="dataDictValue.dataDictId" placeholder="输入数据字典编号"></Input>
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
import DataDictValue from '@/view/com/pro/data/dict/dataDictValue/dataDictValue'

export default {
  name: 'DataDictValueEdit',
  props: {
  },
  data () {
    return {
      dataDictValue: new DataDictValue(),
      dataDictValueFormValidate: {
        code: [
          { required: true, message: '代码不能为空', trigger: 'blur' }
        ],
        displayName: [
          { required: true, message: '显示名称不能为空', trigger: 'blur' }
        ],
        dataDictId: [
          { required: true, message: '数据字典编号不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
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
      'saveDataDictValue',
      'updateDataDictValue',
      'getDataDictValueByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'dataDictValue-list' })
    },
    reset () {
      this.$refs.dataDictValueForm.resetFields()
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
      this.$refs.dataDictValueForm.validate((valid) => {
        if (valid) {
          if (this.dataDictValue.dataDictValueId !== 'add') {
            this.updateDataDictValue(this.dataDictValue).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.dataDictValue = new DataDictValue()
                this.dataDictValue.dataDictValueId = 'add'
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
            this.saveDataDictValue(this.dataDictValue).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据字典值信息保存成功.', duration: 3 })
                this.reset()
                this.dataDictValue = new DataDictValue()
                this.dataDictValue.dataDictValueId = 'add'
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
