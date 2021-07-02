/**
 * Copyright 2019, 2020, 2021 SourceLab.org https://github.com/SourceLabOrg/activecampaign-java-client
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.sourcelab.activecampaign.reseller.request;

import org.sourcelab.activecampaign.JacksonFactory;
import org.sourcelab.activecampaign.reseller.response.AccountAddResponse;
import org.sourcelab.http.rest.request.RequestMethod;

import java.io.IOException;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Add a new account, just like you would on the Manage Accounts page of the reseller panel.
 */
public class AccountAddRequest extends AbstractRequest<AccountAddRequest, AccountAddResponse> {

    public AccountAddRequest() {
        super("account_add");
    }

    public AccountAddRequest withAccount(final String account) {
        return setParam("account", account);
    }

    public AccountAddRequest withCname(final String cname) {
        return setParam("cname", cname);
    }

    public AccountAddRequest withNotification(final String emailAddress) {
        return setParam("notification", emailAddress);
    }

    public AccountAddRequest withPlan(final int planId) {
        return setParam("plan", Integer.toString(planId));
    }

    public AccountAddRequest withLanguage(final Language language) {
        return setParam("language", language.getParametervalue());
    }

    public AccountAddRequest withTimezone(final String timezone) {
        return setParam("timezone", timezone);
    }

    public AccountAddRequest withTimezone(final TimeZone timezone) {
        Objects.requireNonNull(timezone);
        return withTimezone(timezone.getID());
    }

    public AccountAddRequest withSnapshot(final int snapshotId) {
        return setParam("snapshot", Integer.toString(snapshotId));
    }

    public AccountAddRequest withClientName(final String name) {
        return setParam("name", name);
    }

    public AccountAddRequest withClientEmail(final String clientEmail) {
        return setParam("email", clientEmail);
    }

    @Override
    public AccountAddResponse parseResponse(final String response) throws IOException {
        return JacksonFactory.newInstance().readValue(response, AccountAddResponse.class);
    }

    @Override
    public RequestMethod getRequestMethod() {
        return RequestMethod.POST;
    }
}

