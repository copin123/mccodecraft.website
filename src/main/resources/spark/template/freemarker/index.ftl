<#if hasNoParents??>
    <div class="starter-template">
        <h1>${hasNoParents}</h1>
    </div>
<#else>
    <div class="starter-template">
        <#--<#list articles as article>-->
            <h3>${hasParents}</h3>
            <#--<h4>${article.getCreatedAt()}</h4>-->
            <#--<h4>${article.getSummaryLink()}</h4>-->
            <#--<h4>${article.getEditLink()} | ${article.getDeleteLink()}</h4>-->
        <#--</#list>-->
    </div>
</#if>