/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.apigateway.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.apigateway.v1.ApiGatewayServiceClient;
import com.google.cloud.apigateway.v1.ApiGatewayServiceSettings;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link ApiGatewayServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@ConditionalOnClass(ApiGatewayServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.apigateway.v1.spring.auto.api-gateway-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(ApiGatewayServiceSpringProperties.class)
public class ApiGatewayServiceSpringAutoConfiguration {
  private final ApiGatewayServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(ApiGatewayServiceSpringAutoConfiguration.class);

  protected ApiGatewayServiceSpringAutoConfiguration(
      ApiGatewayServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from ApiGatewayService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Returns the default channel provider. The default is gRPC and will default to it unless the
   * useRest option is provided to use HTTP transport instead
   */
  @Bean
  @ConditionalOnMissingBean
  public TransportChannelProvider defaultApiGatewayServiceTransportChannelProvider() {
    return ApiGatewayServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a ApiGatewayServiceClient bean configured to use the default credentials provider
   * (obtained with apiGatewayServiceCredentials()) and its default transport channel provider
   * (defaultApiGatewayServiceTransportChannelProvider()). It also configures the quota project ID
   * if provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in ApiGatewayServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public ApiGatewayServiceSettings apiGatewayServiceSettings(
      @Qualifier("defaultApiGatewayServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    ApiGatewayServiceSettings.Builder clientSettingsBuilder =
        ApiGatewayServiceSettings.newBuilder()
            .setCredentialsProvider(this.credentialsProvider)
            .setTransportChannelProvider(defaultTransportChannelProvider)
            .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          ApiGatewayServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder.setTransportChannelProvider(
          ApiGatewayServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings listGatewaysRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGatewaysSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listGatewaysSettings().setRetrySettings(listGatewaysRetrySettings);

      RetrySettings getGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGatewaySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getGatewaySettings().setRetrySettings(getGatewayRetrySettings);

      RetrySettings createGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createGatewaySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createGatewaySettings().setRetrySettings(createGatewayRetrySettings);

      RetrySettings updateGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateGatewaySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateGatewaySettings().setRetrySettings(updateGatewayRetrySettings);

      RetrySettings deleteGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteGatewaySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteGatewaySettings().setRetrySettings(deleteGatewayRetrySettings);

      RetrySettings listApisRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listApisSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listApisSettings().setRetrySettings(listApisRetrySettings);

      RetrySettings getApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getApiSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getApiSettings().setRetrySettings(getApiRetrySettings);

      RetrySettings createApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createApiSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createApiSettings().setRetrySettings(createApiRetrySettings);

      RetrySettings updateApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateApiSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateApiSettings().setRetrySettings(updateApiRetrySettings);

      RetrySettings deleteApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteApiSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteApiSettings().setRetrySettings(deleteApiRetrySettings);

      RetrySettings listApiConfigsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listApiConfigsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listApiConfigsSettings().setRetrySettings(listApiConfigsRetrySettings);

      RetrySettings getApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getApiConfigSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getApiConfigSettings().setRetrySettings(getApiConfigRetrySettings);

      RetrySettings createApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createApiConfigSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createApiConfigSettings()
          .setRetrySettings(createApiConfigRetrySettings);

      RetrySettings updateApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateApiConfigSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .updateApiConfigSettings()
          .setRetrySettings(updateApiConfigRetrySettings);

      RetrySettings deleteApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteApiConfigSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deleteApiConfigSettings()
          .setRetrySettings(deleteApiConfigRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listGatewaysRetry = clientProperties.getListGatewaysRetry();
    if (listGatewaysRetry != null) {
      RetrySettings listGatewaysRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listGatewaysSettings().getRetrySettings(), listGatewaysRetry);
      clientSettingsBuilder.listGatewaysSettings().setRetrySettings(listGatewaysRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listGateways from properties.");
      }
    }
    Retry getGatewayRetry = clientProperties.getGetGatewayRetry();
    if (getGatewayRetry != null) {
      RetrySettings getGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getGatewaySettings().getRetrySettings(), getGatewayRetry);
      clientSettingsBuilder.getGatewaySettings().setRetrySettings(getGatewayRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getGateway from properties.");
      }
    }
    Retry createGatewayRetry = clientProperties.getCreateGatewayRetry();
    if (createGatewayRetry != null) {
      RetrySettings createGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createGatewaySettings().getRetrySettings(), createGatewayRetry);
      clientSettingsBuilder.createGatewaySettings().setRetrySettings(createGatewayRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createGateway from properties.");
      }
    }
    Retry updateGatewayRetry = clientProperties.getUpdateGatewayRetry();
    if (updateGatewayRetry != null) {
      RetrySettings updateGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateGatewaySettings().getRetrySettings(), updateGatewayRetry);
      clientSettingsBuilder.updateGatewaySettings().setRetrySettings(updateGatewayRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateGateway from properties.");
      }
    }
    Retry deleteGatewayRetry = clientProperties.getDeleteGatewayRetry();
    if (deleteGatewayRetry != null) {
      RetrySettings deleteGatewayRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteGatewaySettings().getRetrySettings(), deleteGatewayRetry);
      clientSettingsBuilder.deleteGatewaySettings().setRetrySettings(deleteGatewayRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteGateway from properties.");
      }
    }
    Retry listApisRetry = clientProperties.getListApisRetry();
    if (listApisRetry != null) {
      RetrySettings listApisRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listApisSettings().getRetrySettings(), listApisRetry);
      clientSettingsBuilder.listApisSettings().setRetrySettings(listApisRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listApis from properties.");
      }
    }
    Retry getApiRetry = clientProperties.getGetApiRetry();
    if (getApiRetry != null) {
      RetrySettings getApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getApiSettings().getRetrySettings(), getApiRetry);
      clientSettingsBuilder.getApiSettings().setRetrySettings(getApiRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getApi from properties.");
      }
    }
    Retry createApiRetry = clientProperties.getCreateApiRetry();
    if (createApiRetry != null) {
      RetrySettings createApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createApiSettings().getRetrySettings(), createApiRetry);
      clientSettingsBuilder.createApiSettings().setRetrySettings(createApiRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createApi from properties.");
      }
    }
    Retry updateApiRetry = clientProperties.getUpdateApiRetry();
    if (updateApiRetry != null) {
      RetrySettings updateApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateApiSettings().getRetrySettings(), updateApiRetry);
      clientSettingsBuilder.updateApiSettings().setRetrySettings(updateApiRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateApi from properties.");
      }
    }
    Retry deleteApiRetry = clientProperties.getDeleteApiRetry();
    if (deleteApiRetry != null) {
      RetrySettings deleteApiRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteApiSettings().getRetrySettings(), deleteApiRetry);
      clientSettingsBuilder.deleteApiSettings().setRetrySettings(deleteApiRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteApi from properties.");
      }
    }
    Retry listApiConfigsRetry = clientProperties.getListApiConfigsRetry();
    if (listApiConfigsRetry != null) {
      RetrySettings listApiConfigsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listApiConfigsSettings().getRetrySettings(),
              listApiConfigsRetry);
      clientSettingsBuilder.listApiConfigsSettings().setRetrySettings(listApiConfigsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listApiConfigs from properties.");
      }
    }
    Retry getApiConfigRetry = clientProperties.getGetApiConfigRetry();
    if (getApiConfigRetry != null) {
      RetrySettings getApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getApiConfigSettings().getRetrySettings(), getApiConfigRetry);
      clientSettingsBuilder.getApiConfigSettings().setRetrySettings(getApiConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getApiConfig from properties.");
      }
    }
    Retry createApiConfigRetry = clientProperties.getCreateApiConfigRetry();
    if (createApiConfigRetry != null) {
      RetrySettings createApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createApiConfigSettings().getRetrySettings(),
              createApiConfigRetry);
      clientSettingsBuilder
          .createApiConfigSettings()
          .setRetrySettings(createApiConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createApiConfig from properties.");
      }
    }
    Retry updateApiConfigRetry = clientProperties.getUpdateApiConfigRetry();
    if (updateApiConfigRetry != null) {
      RetrySettings updateApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateApiConfigSettings().getRetrySettings(),
              updateApiConfigRetry);
      clientSettingsBuilder
          .updateApiConfigSettings()
          .setRetrySettings(updateApiConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateApiConfig from properties.");
      }
    }
    Retry deleteApiConfigRetry = clientProperties.getDeleteApiConfigRetry();
    if (deleteApiConfigRetry != null) {
      RetrySettings deleteApiConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteApiConfigSettings().getRetrySettings(),
              deleteApiConfigRetry);
      clientSettingsBuilder
          .deleteApiConfigSettings()
          .setRetrySettings(deleteApiConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteApiConfig from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public ApiGatewayServiceClient apiGatewayServiceClient(
      ApiGatewayServiceSettings apiGatewayServiceSettings) throws IOException {
    return ApiGatewayServiceClient.create(apiGatewayServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-api-gateway-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
