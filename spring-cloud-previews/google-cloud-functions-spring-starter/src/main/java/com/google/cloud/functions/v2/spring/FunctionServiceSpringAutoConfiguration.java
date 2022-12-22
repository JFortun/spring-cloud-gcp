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

package com.google.cloud.functions.v2.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.functions.v2.FunctionServiceClient;
import com.google.cloud.functions.v2.FunctionServiceSettings;
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
 * Auto-configuration for {@link FunctionServiceClient}.
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
@ConditionalOnClass(FunctionServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.functions.v2.spring.auto.function-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(FunctionServiceSpringProperties.class)
public class FunctionServiceSpringAutoConfiguration {
  private final FunctionServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(FunctionServiceSpringAutoConfiguration.class);

  protected FunctionServiceSpringAutoConfiguration(
      FunctionServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from FunctionService-specific configuration");
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
  public TransportChannelProvider defaultFunctionServiceTransportChannelProvider() {
    return FunctionServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a FunctionServiceClient bean configured to use the default credentials provider
   * (obtained with functionServiceCredentials()) and its default transport channel provider
   * (defaultFunctionServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in FunctionServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public FunctionServiceSettings functionServiceSettings(
      @Qualifier("defaultFunctionServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    FunctionServiceSettings.Builder clientSettingsBuilder =
        FunctionServiceSettings.newBuilder()
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
          FunctionServiceSettings.defaultExecutorProviderBuilder()
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
          FunctionServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings getFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFunctionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getFunctionSettings().setRetrySettings(getFunctionRetrySettings);

      RetrySettings listFunctionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFunctionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listFunctionsSettings().setRetrySettings(listFunctionsRetrySettings);

      RetrySettings createFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createFunctionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createFunctionSettings().setRetrySettings(createFunctionRetrySettings);

      RetrySettings updateFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateFunctionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateFunctionSettings().setRetrySettings(updateFunctionRetrySettings);

      RetrySettings deleteFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteFunctionSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteFunctionSettings().setRetrySettings(deleteFunctionRetrySettings);

      RetrySettings generateUploadUrlRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.generateUploadUrlSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .generateUploadUrlSettings()
          .setRetrySettings(generateUploadUrlRetrySettings);

      RetrySettings generateDownloadUrlRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.generateDownloadUrlSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .generateDownloadUrlSettings()
          .setRetrySettings(generateDownloadUrlRetrySettings);

      RetrySettings listRuntimesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRuntimesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listRuntimesSettings().setRetrySettings(listRuntimesRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getFunctionRetry = clientProperties.getGetFunctionRetry();
    if (getFunctionRetry != null) {
      RetrySettings getFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFunctionSettings().getRetrySettings(), getFunctionRetry);
      clientSettingsBuilder.getFunctionSettings().setRetrySettings(getFunctionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getFunction from properties.");
      }
    }
    Retry listFunctionsRetry = clientProperties.getListFunctionsRetry();
    if (listFunctionsRetry != null) {
      RetrySettings listFunctionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFunctionsSettings().getRetrySettings(), listFunctionsRetry);
      clientSettingsBuilder.listFunctionsSettings().setRetrySettings(listFunctionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listFunctions from properties.");
      }
    }
    Retry createFunctionRetry = clientProperties.getCreateFunctionRetry();
    if (createFunctionRetry != null) {
      RetrySettings createFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createFunctionSettings().getRetrySettings(),
              createFunctionRetry);
      clientSettingsBuilder.createFunctionSettings().setRetrySettings(createFunctionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createFunction from properties.");
      }
    }
    Retry updateFunctionRetry = clientProperties.getUpdateFunctionRetry();
    if (updateFunctionRetry != null) {
      RetrySettings updateFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateFunctionSettings().getRetrySettings(),
              updateFunctionRetry);
      clientSettingsBuilder.updateFunctionSettings().setRetrySettings(updateFunctionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateFunction from properties.");
      }
    }
    Retry deleteFunctionRetry = clientProperties.getDeleteFunctionRetry();
    if (deleteFunctionRetry != null) {
      RetrySettings deleteFunctionRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteFunctionSettings().getRetrySettings(),
              deleteFunctionRetry);
      clientSettingsBuilder.deleteFunctionSettings().setRetrySettings(deleteFunctionRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteFunction from properties.");
      }
    }
    Retry generateUploadUrlRetry = clientProperties.getGenerateUploadUrlRetry();
    if (generateUploadUrlRetry != null) {
      RetrySettings generateUploadUrlRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.generateUploadUrlSettings().getRetrySettings(),
              generateUploadUrlRetry);
      clientSettingsBuilder
          .generateUploadUrlSettings()
          .setRetrySettings(generateUploadUrlRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for generateUploadUrl from properties.");
      }
    }
    Retry generateDownloadUrlRetry = clientProperties.getGenerateDownloadUrlRetry();
    if (generateDownloadUrlRetry != null) {
      RetrySettings generateDownloadUrlRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.generateDownloadUrlSettings().getRetrySettings(),
              generateDownloadUrlRetry);
      clientSettingsBuilder
          .generateDownloadUrlSettings()
          .setRetrySettings(generateDownloadUrlRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for generateDownloadUrl from properties.");
      }
    }
    Retry listRuntimesRetry = clientProperties.getListRuntimesRetry();
    if (listRuntimesRetry != null) {
      RetrySettings listRuntimesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRuntimesSettings().getRetrySettings(), listRuntimesRetry);
      clientSettingsBuilder.listRuntimesSettings().setRetrySettings(listRuntimesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listRuntimes from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry setIamPolicyRetry = clientProperties.getSetIamPolicyRetry();
    if (setIamPolicyRetry != null) {
      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), setIamPolicyRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for setIamPolicy from properties.");
      }
    }
    Retry getIamPolicyRetry = clientProperties.getGetIamPolicyRetry();
    if (getIamPolicyRetry != null) {
      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), getIamPolicyRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIamPolicy from properties.");
      }
    }
    Retry testIamPermissionsRetry = clientProperties.getTestIamPermissionsRetry();
    if (testIamPermissionsRetry != null) {
      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(),
              testIamPermissionsRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for testIamPermissions from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public FunctionServiceClient functionServiceClient(
      FunctionServiceSettings functionServiceSettings) throws IOException {
    return FunctionServiceClient.create(functionServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-function-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
