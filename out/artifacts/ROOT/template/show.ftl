<!DOCTYPE html>
<html>
<#include "/include/head.ftl">
<body>
<#include "/include/support.ftl">
<#include "/include/header.ftl">
<div class="g-doc">
<#if product??>
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="${product.pic}" alt=""></div>
        <div class="cnt">
            <h2>${product.title}</h2>
            <p class="summary">${product.summary}</p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value">${product.price}</span>
            </div>
            <div class="num">数量：<span id="plusNum" class="lessNum"><a>-</a></span><span class="totalNum"
                                                                                          id="allNum">${product.buyNum}</span><span
                    id="addNum" class="moreNum"><a>+</a></span></div>
            <div class="oprt f-cb">
                <#if user?? && user.userType==0>
                    <#if product.isBuy>
                        <button class="u-btn u-btn-primary" id="add" data-id="${product.id}"
                                data-title="${product.title}" data-price="${product.price}">
                            再次购买
                        </button>
                        <span class="buyprice">当时购买价格：¥${product.buyPrice} 数量：${product.buyNum}</span>
                    <#else>
                        <button class="u-btn u-btn-primary" id="add" data-id="${product.id}"
                                data-title="${product.title}" data-price="${product.price}">
                            加入购物车
                        </button>
                    </#if>
                </#if>
                <#if user?? && user.userType==1>
                    <a href="/edit?id=${product.id}" class="u-btn u-btn-primary">编 辑</a>
                </#if>
            </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
    ${product.detail}
    </div>
<#else>
    <div class="n-result">
        <h3>内容不存在！</h3>
    </div>
</#if>
</div>
<#include "/include/footer.ftl">
<script type="text/javascript" src="/js/global.js"></script>
<script type="text/javascript" src="/js/pageShow.js"></script>
</body>
</html>