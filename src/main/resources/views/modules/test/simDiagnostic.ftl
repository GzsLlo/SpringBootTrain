<#assign basePath=request.contextPath />
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- BEGIN CSS -->
<base id="basePath" href="${basePath}">
<#--<link rel="stylesheet" type="text/css" href="<@s.url '/static/css/modules/User/simsDiagnostic.css'/>"/>
<script type="text/javascript" src="<@s.url '/static/js/modules/User/simDiagnostic.js'/>"></script>-->
<!-- END PAGE LEVEL STYLES -->
<link rel="stylesheet" href="${basePath}/static/css/modules/test/simDiagnostic.css"/>
<script type="text/javascript" src="${basePath}/static/js/modules/test/simDiagnostic.js"></script>

<div style="margin: 30px">
  <div class="portlet-title">
    <div class="caption">
      <div class="row">
        <div class="col-md-4">
          <h3 class="caption-subject font-red-sunglo bold uppercase">
            诊断
          </h3>
        </div>
      </div>
    </div>
  </div>
  <div class="row margin-top-10">
    <div class="col-md-4">
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          设备状态
        </div>
        <div id="diagnosticDeviceStatus" class="col-md-7">
          检测中
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          SIM
        </div>
        <div class="col-md-7">
          ${iccid}
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          在线
        </div>
        <div class="col-md-7">
          是
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          SIM卡状态
        </div>
        <div class="col-md-7">
          激活
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          禁用SIM卡
        </div>
        <div class="col-md-7">
          否
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          已达到区域用量限额
        </div>
        <div class="col-md-7">
          否
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          用量限额重置
        </div>
        <div class="col-md-7">
          否
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          已达到用量限额
        </div>
        <div class="col-md-7">
          否
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          资费计划
        </div>
        <div class="col-md-7">
          月付单个
        </div>
      </div>
      <div class="row margin-bottom-20">
        <div class="col-md-5 fontSize">
          周期累计数据（MB）
        </div>
        <div class="col-md-7">
          19
        </div>
      </div>
    </div>
    <div class="col-md-7">
      <div class="row config diag-items">
        <div class="diag-item-panel">
          <div class="col-md-3 border-right">
            <div class="icon">
              <div class="icon-base prvg-icon">
                <span id="config-status-icon" class="readyIcon"></span>
              </div>
            </div>
            <div id="config-status"
                 class="status-txt pending"> 待处理
            </div>
            <div class="clearfix"></div>
          </div>
          <div class="col-md-9 gradientBgd">
            <div class="diagnosticTitle">配置</div>
            <div class="config-desc">诊断中...</div>
            <div class="clearfix"></div>
          </div>
        </div>
        <div class="config-msg" hidden>
          测试失败的可能原因
          <ul id="config-reason">
          </ul>
          解决此问题的常见步骤包括:
          <ul id="config-solution">
          </ul>
        </div>
      </div>
      <div class="row device diag-items">
        <div class="diag-item-panel">
          <div class="col-md-3 border-right">
            <div class="icon">
              <div class="icon-base prvg-icon">
                <span id="prvg-status-icon" class="readyIcon"></span>
              </div>
            </div>
            <div id="prvg-status" class="status-txt pending">待处理</div>
            <div class="clearfix"></div>
          </div>
          <div class="col-md-9 gradientBgd">
            <div class="diagnosticTitle">SIM 卡/设备</div>
            <div class="device-desc">诊断中...</div>
            <div class="clearfix"></div>
          </div>
        </div>
        <div class="device-msg" hidden>
          测试失败的可能原因
          <ul id="prvg-reason">
          </ul>
          解决此问题的常见步骤包括：
          <ul id="prvg-solution">
          </ul>
        </div>
      </div>
      <div class="row internetConnection diag-items">
        <div class="diag-item-panel">
          <div class="col-md-3 border-right">
            <div class="icon">
              <div class="icon-base prvg-icon">
                <span id="internet-status-icon" class="readyIcon"></span>
              </div>
            </div>
            <div id="internetConnection-status"
                 class="status-txt pending">待处理
            </div>
            <div class="clearfix"></div>
          </div>
          <div class="col-md-9 gradientBgd">
            <div class="diagnosticTitle">网络连接</div>
            <div class="internetConnection-desc">诊断中...</div>
            <div class="clearfix"></div>
          </div>
        </div>
        <div class="internetConnection-msg" hidden>
          <p id="internetConnection-result"></p>
          解决此问题的常见步骤包括：
          <ul id="internetConnection-solution">
            <li id="itConntFirstSolution"></li>
            <li id="itConntSecondSolution"></li>
          </ul>
          <p id="itConntFirstAttention"></p>
          <p id="itConntSecondAttention"></p>
        </div>
      </div>
      <div class="row ipOrInternet diag-items">
        <div class="diag-item-panel">
          <div class="col-md-3 border-right">
            <div class="icon">
              <div class="icon-base prvg-icon">
                <span id="ipOrInternet-status-icon" class="readyIcon"></span>
              </div>
            </div>
            <div id="ipOrInternet-status"
                 class="status-txt pending">待处理
            </div>
            <div class="clearfix"></div>
          </div>
          <div class="col-md-9 gradientBgd">
            <div class="diagnosticTitle">IP/互联网</div>
            <div class="ipOrInternet-desc">诊断中...</div>
            <div class="clearfix"></div>
          </div>
        </div>
        <div class="ipOrInternet-msg" hidden>
          测试失败的可能原因：
          <ul id="ipOrInternet-reason">
          </ul>
          解决此问题的常见步骤包括：
          <ul id="ipOrInternet-solution">
          </ul>
        </div>
      </div>
    </div>
  </div>
</div>
<div class="row">
  <div class="col-md-12">
    <div class="col-md-4 margin-top-18">
      <a style="color:#00b3ee" class="btn btn-circle btn-sm col-md-3">
        后续步骤</a>
      <a href="#SIMInfo" data-toggle="modal" class="btn btn-circle btn-sm grey col-md-3"
         type="button" style="display: none">SIM卡信息</a>
      <a href="#sendTextMessage" data-toggle="modal" class="btn btn-circle btn-sm grey col-md-3"
         type="button">发送短信</a>
      <a id="cancelLocationBtn" data-toggle="modal" class="btn btn-circle btn-sm grey col-md-3"
         type="button">取消位置</a>
    </div>
  </div>
</div>
</div>

<!-- BEGIN SIM INFO MODAL -->
<div class="modal fade bs-modal-lg" id="SIMInfo">
  <input id ='testdiv' field="dasd" disabled>
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">SIM卡信息</h4>
      </div>
      <div class="modal-body" style="margin: 0 15px 0 15px">
        <table class="table table-striped table-bordered table-hover display nowrap" width="100%"
               id="chargeCurrentDosage">
          <thead>
          <tr>
            <th>SIM卡信息</th>
            <th>最后已知值</th>
            <th>上次更新日期</th>
            <th>操作</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <th>Roaming Restriction</th>
            <th>0</th>
            <th>2017.09.12 10:26</th>
            <th></th>
          </tr>
          <tr>
            <th>APNs</th>
            <th>0</th>
            <th>2017.09.12 10:26</th>
            <th></th>
          </tr>
          <tr>
            <th>SGSN</th>
            <th>0</th>
            <th>2017.09.12 10:26</th>
            <th></th>
          </tr>
          <tr>
            <th>MSC</th>
            <th>0</th>
            <th>2017.09.12 10:26</th>
            <th></th>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<!-- END SIM INFO  MODAL -->

<!-- BEGIN SEND TEXT MESSAGES MODAL -->
<div class="modal fade bs-modal-lg" id="sendTextMessage">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
        <h4 class="modal-title">发送短信</h4>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-md-2">
            <div class="form-group">
              <label class="col-md-12">短消息:</label>
              <div class="col-md-8">
                <p style="color: grey">(必填)</p>
              </div>
            </div>
          </div>
          <div class="col-md-8">
            <textarea id="msgContent" style="width: 100%;height: 200px;max-width:650px;
            max-height: 250px;min-height: 150px;min-width: 250px" maxlength="320"
                      placeholder="(限320字)"></textarea>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <a href="javascript:;" class="btn green button-submit" id="sendMsgBtn">
          发送<i class="m-icon-swapright m-icon-white"></i>
        </a>
        <a href="javascript:;" class="btn red button-cancel" data-dismiss="modal">
          取消<i class="m-icon-swapright m-icon-white"></i>
        </a>
      </div>
    </div>
  </div>
</div>
<!-- END SEND TEXT MESSAGES MODAL -->
<input type="hidden" id="simDiagnosticInfo" deviceId="20180205016728152450" iccId="20180205016728152099"
       devAcctId="20180205016728152960" username="china_manager" msisdn="672815615210297" partitionId="2450">



