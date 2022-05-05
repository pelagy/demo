<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h2><button type="submit"><a href="/">Back</a></button>Login page</h2>
    <#if error??><p>${error}</#if>
    <#if logout??><p>${logout}</#if>
    <@l.login "/login" />
    <form action="/registration">
        <button type="submit">Registration</button>
    </form>
</@c.page>