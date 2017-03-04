<div class="starter-template">
    <form class="form-horizontal" role="form" id='parentInfo-create-form' method='POST'
        <#if parentInfo??>action="/parentInfo/update/:id"<#else>action="/parentInfo/create"
        </#if>>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="title">Title:</label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="title" name='parentInfo-title' placeholder="Enter a new title"
                <#if parentInfo??>value="${parentInfo.getTitle()}"</#if> />
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-3 control-label" for="summary">Summary:</label>
            <div class="col-sm-5">
                <input class="form-control" type='text' id="summary" name='parentInfo-summary' placeholder="Enter a new summary"
                <#if parentInfo??>value="${parentInfo.getSummary()}" </#if> />
            </div>
        </div>
        <#if parentInfo??>
            <input type='hidden' name='parentInfo-id' value="${parentInfo.getId()}"/>
        </#if>
    </form>

    <label for="content">Content</label>
    <textarea class="form-control" name='parentInfo-content' id="content" rows='4' cols='50' form='parentInfo-create-form'
          placeholder="Enter parentInfo content"><#if parentInfo??>${parentInfo.getContent()}</#if>
    </textarea>
    <input type='submit' <#if parentInfo??>value='Update'<#else>value='Publish'</#if> class="btn btn-primary" form='parentInfo-create-form' />
</div>