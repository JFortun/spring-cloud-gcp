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

package com.google.cloud.aiplatform.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.aiplatform.v1.EndpointServiceClient;
import com.google.cloud.aiplatform.v1.EndpointServiceSettings;
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
 * Auto-configuration for {@link EndpointServiceClient}.
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
@ConditionalOnClass(EndpointServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.aiplatform.v1.spring.auto.endpoint-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(EndpointServiceSpringProperties.class)
public class EndpointServiceSpringAutoConfiguration {
  private final EndpointServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(EndpointServiceSpringAutoConfiguration.class);

  protected EndpointServiceSpringAutoConfiguration(
      EndpointServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from EndpointService-specific configuration");
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
  public TransportChannelProvider defaultEndpointServiceTransportChannelProvider() {
    return EndpointServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a EndpointServiceClient bean configured to use the default credentials provider
   * (obtained with endpointServiceCredentials()) and its default transport channel provider
   * (defaultEndpointServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in EndpointServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public EndpointServiceSettings endpointServiceSettings(
      @Qualifier("defaultEndpointServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    EndpointServiceSettings.Builder clientSettingsBuilder =
        EndpointServiceSettings.newBuilder()
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
          EndpointServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings createEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createEndpointSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createEndpointSettings().setRetrySettings(createEndpointRetrySettings);

      RetrySettings getEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEndpointSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getEndpointSettings().setRetrySettings(getEndpointRetrySettings);

      RetrySettings listEndpointsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEndpointsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listEndpointsSettings().setRetrySettings(listEndpointsRetrySettings);

      RetrySettings updateEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateEndpointSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateEndpointSettings().setRetrySettings(updateEndpointRetrySettings);

      RetrySettings deleteEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteEndpointSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteEndpointSettings().setRetrySettings(deleteEndpointRetrySettings);

      RetrySettings deployModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deployModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deployModelSettings().setRetrySettings(deployModelRetrySettings);

      RetrySettings undeployModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.undeployModelSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.undeployModelSettings().setRetrySettings(undeployModelRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

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
    Retry createEndpointRetry = clientProperties.getCreateEndpointRetry();
    if (createEndpointRetry != null) {
      RetrySettings createEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createEndpointSettings().getRetrySettings(),
              createEndpointRetry);
      clientSettingsBuilder.createEndpointSettings().setRetrySettings(createEndpointRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createEndpoint from properties.");
      }
    }
    Retry getEndpointRetry = clientProperties.getGetEndpointRetry();
    if (getEndpointRetry != null) {
      RetrySettings getEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getEndpointSettings().getRetrySettings(), getEndpointRetry);
      clientSettingsBuilder.getEndpointSettings().setRetrySettings(getEndpointRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getEndpoint from properties.");
      }
    }
    Retry listEndpointsRetry = clientProperties.getListEndpointsRetry();
    if (listEndpointsRetry != null) {
      RetrySettings listEndpointsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listEndpointsSettings().getRetrySettings(), listEndpointsRetry);
      clientSettingsBuilder.listEndpointsSettings().setRetrySettings(listEndpointsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listEndpoints from properties.");
      }
    }
    Retry updateEndpointRetry = clientProperties.getUpdateEndpointRetry();
    if (updateEndpointRetry != null) {
      RetrySettings updateEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateEndpointSettings().getRetrySettings(),
              updateEndpointRetry);
      clientSettingsBuilder.updateEndpointSettings().setRetrySettings(updateEndpointRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateEndpoint from properties.");
      }
    }
    Retry deleteEndpointRetry = clientProperties.getDeleteEndpointRetry();
    if (deleteEndpointRetry != null) {
      RetrySettings deleteEndpointRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteEndpointSettings().getRetrySettings(),
              deleteEndpointRetry);
      clientSettingsBuilder.deleteEndpointSettings().setRetrySettings(deleteEndpointRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteEndpoint from properties.");
      }
    }
    Retry deployModelRetry = clientProperties.getDeployModelRetry();
    if (deployModelRetry != null) {
      RetrySettings deployModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deployModelSettings().getRetrySettings(), deployModelRetry);
      clientSettingsBuilder.deployModelSettings().setRetrySettings(deployModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deployModel from properties.");
      }
    }
    Retry undeployModelRetry = clientProperties.getUndeployModelRetry();
    if (undeployModelRetry != null) {
      RetrySettings undeployModelRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.undeployModelSettings().getRetrySettings(), undeployModelRetry);
      clientSettingsBuilder.undeployModelSettings().setRetrySettings(undeployModelRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for undeployModel from properties.");
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
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
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
  public EndpointServiceClient endpointServiceClient(
      EndpointServiceSettings endpointServiceSettings) throws IOException {
    return EndpointServiceClient.create(endpointServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-endpoint-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
