import { Injectable, Injector } from '@angular/core';
import { Http, Request, RequestOptions, RequestOptionsArgs, Response, XHRBackend } from '@angular/http';
import { Observable } from 'rxjs';

@Injectable()
export class ExtendedHttp extends Http {

    constructor(backend: XHRBackend, defaultOptions: RequestOptions, private injector: Injector) {
        super(backend, defaultOptions);
    }

    request(url: string | Request, options?: RequestOptionsArgs): Observable<Response> {

        let requestUrl: string;

        if (typeof url === 'string') {
            requestUrl = url;
        } else {
            requestUrl = url.url;
        }

        if (requestUrl.indexOf('rldp-diceapp-service') >= 0) {
            this.overrideUrl(url);
        }

        return super.request(url, options);
    }

    private overrideUrl(request: string | Request): void {
        const apiDomain = sessionStorage.getItem('apiDomain');
        if (apiDomain) {
            if (typeof request === 'string') {
                request = apiDomain.concat(request);
            } else {
                request.url = apiDomain.concat(request.url);
            }
        }
    }

}
