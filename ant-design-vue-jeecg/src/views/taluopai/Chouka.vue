<template>
    <a-card :bordered="false">
    <!-- 查询区域 -->
    <div class="table-page-search-wrapper">
      
      <a-form layout="inline">
        <a-row :gutter="24">         
          <a-col :md="4" :sm="12">
           <a-form-item label="编号" style="margin-left:8px">
              <a-input placeholder=" " v-model="queryParam.no"></a-input>
            </a-form-item>
          </a-col>
          <a-col :md="6" :sm="4" style="text-align:right;">
            <a-button type="default" @click="SearchTaluo" icon="search" :loading="iconLoading" style="margin-left: 1028px;">开始</a-button>
          </a-col>    
        </a-row> 
        <a-row :gutter="24">
          <a-col :md="4" :sm="12">
           <a-form-item label="牌名" style="margin-left:8px">
              <a-input placeholder=" " v-model="queryParam.name"></a-input>
            </a-form-item>
          </a-col>     
        </a-row> 
        <a-row :gutter="24">
          <a-col :md="20" :sm="12">
            <a-form-item label="牌面解读" style="margin-left:8px">
              <a-textarea  placeholder="" :autosize="{ minRows: 2, maxRows: 6 }" v-model="queryParam.unscramble"/>
            </a-form-item>
          </a-col> 
        </a-row> 
        </a-form>

        <a-form layout="inline" style="margin-top:100px">
          <a-row :gutter="24" v-if="queryParam.type == 0">
            <a-col :md="20" :sm="12">
              <a-form-item label="正位释义" style="margin-left:8px">
                <a-textarea  placeholder="" :autosize="{ minRows: 2, maxRows: 6 }" v-model="queryParam.normotopia"/>
              </a-form-item>
            </a-col> 
          </a-row> 
          <a-row :gutter="24" v-if="queryParam.type == 1">
            <a-col :md="20" :sm="12" >
              <a-form-item label="逆位释义" style="margin-left:8px">
                <a-textarea  placeholder="" :autosize="{ minRows: 2, maxRows: 6 }" v-model="queryParam.inversion"/>
              </a-form-item>
            </a-col> 
          </a-row>   
      </a-form>
    </div>                         

  </a-card>
</template>
<script>
  import { filterObj } from '@/utils/util'
  import {JeecgListMixin} from '@/mixins/JeecgListMixin'
  import {taluo} from '@/api/manage'


  export default {
    name: "Chouka",
    mixins: [JeecgListMixin],
    components: {
     
    },
    data() {
      return {
        iconLoading:false,
        
        url: {
          list: "/sys/user/departUserList",
          taluo: "/test/jeecgDemo2/taluo",
          edit: "/sys/user/editSysDepartWithUser",
          delete: "/sys/user/deleteUserInDepart",
          deleteBatch: "/sys/user/deleteUserInDepartBatch",
        }
      }
    },
    created() {
    },

    methods: {

      loadData(arg) {
        
      },
      getQueryParams(){
        var param = Object.assign({}, this.queryParam,this.isorter);
        param.field = this.getQueryField();
        param.pageNo = this.ipagination.current;
        param.pageSize = this.ipagination.pageSize;
        return filterObj(param);
      },

      SearchTaluo() {
        let params = {};       
        this.iconLoading = true;
        setTimeout(()=>{
			    	this.iconLoading=false;         			
				},3000);
        taluo(this.url.taluo, params).then((res) => {
          console.log(res);
          if (res.success) {
            this.queryParam = res.result;
            this.$message.success(res.message);
          } else {
            this.$message.warning(res.message);
          }
        })
      }
    }
  }
</script>
<style scoped>
  @import '~@assets/less/common.less'
</style>