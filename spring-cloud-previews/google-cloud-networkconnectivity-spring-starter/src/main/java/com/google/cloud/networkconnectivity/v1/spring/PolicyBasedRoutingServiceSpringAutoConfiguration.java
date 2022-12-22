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

package com.google.cloud.networkconnectivity.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceClient;
import com.google.cloud.networkconnectivity.v1.PolicyBasedRoutingServiceSettings;
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
 * Auto-configuration for {@link PolicyBasedRoutingServiceClient}.
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
@ConditionalOnClass(PolicyBasedRoutingServiceClient.class)
@ConditionalOnProperty(
    value =
        "com.google.cloud.networkconnectivity.v1.spring.auto.policy-based-routing-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(PolicyBasedRoutingServiceSpringProperties.class)
public class PolicyBasedRoutingServiceSpringAutoConfiguration {
  private final PolicyBasedRoutingServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(PolicyBasedRoutingServiceSpringAutoConfiguration.class);

  protected PolicyBasedRoutingServiceSpringAutoConfiguration(
      PolicyBasedRoutingServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from PolicyBasedRoutingService-specific configuration");
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
  public TransportChannelProvider defaultPolicyBasedRoutingServiceTransportChannelProvider() {
    return PolicyBasedRoutingServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a PolicyBasedRoutingServiceClient bean configured to use the default credentials
   * provider (obtained with policyBasedRoutingServiceCredentials()) and its default transport
   * channel provider (defaultPolicyBasedRoutingServiceTransportChannelProvider()). It also
   * configures the quota project ID if provided. It will configure an executor provider in case
   * there is more than one thread configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in PolicyBasedRoutingServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public PolicyBasedRoutingServiceSettings policyBasedRoutingServiceSettings(
      @Qualifier("defaultPolicyBasedRoutingServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    PolicyBasedRoutingServiceSettings.Builder clientSettingsBuilder =
        PolicyBasedRoutingServiceSettings.newBuilder()
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
          PolicyBasedRoutingServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings listPolicyBasedRoutesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listPolicyBasedRoutesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .listPolicyBasedRoutesSettings()
          .setRetrySettings(listPolicyBasedRoutesRetrySettings);

      RetrySettings getPolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getPolicyBasedRouteSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getPolicyBasedRouteSettings()
          .setRetrySettings(getPolicyBasedRouteRetrySettings);

      RetrySettings createPolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createPolicyBasedRouteSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .createPolicyBasedRouteSettings()
          .setRetrySettings(createPolicyBasedRouteRetrySettings);

      RetrySettings deletePolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePolicyBasedRouteSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .deletePolicyBasedRouteSettings()
          .setRetrySettings(deletePolicyBasedRouteRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry listPolicyBasedRoutesRetry = clientProperties.getListPolicyBasedRoutesRetry();
    if (listPolicyBasedRoutesRetry != null) {
      RetrySettings listPolicyBasedRoutesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listPolicyBasedRoutesSettings().getRetrySettings(),
              listPolicyBasedRoutesRetry);
      clientSettingsBuilder
          .listPolicyBasedRoutesSettings()
          .setRetrySettings(listPolicyBasedRoutesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listPolicyBasedRoutes from properties.");
      }
    }
    Retry getPolicyBasedRouteRetry = clientProperties.getGetPolicyBasedRouteRetry();
    if (getPolicyBasedRouteRetry != null) {
      RetrySettings getPolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getPolicyBasedRouteSettings().getRetrySettings(),
              getPolicyBasedRouteRetry);
      clientSettingsBuilder
          .getPolicyBasedRouteSettings()
          .setRetrySettings(getPolicyBasedRouteRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getPolicyBasedRoute from properties.");
      }
    }
    Retry createPolicyBasedRouteRetry = clientProperties.getCreatePolicyBasedRouteRetry();
    if (createPolicyBasedRouteRetry != null) {
      RetrySettings createPolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createPolicyBasedRouteSettings().getRetrySettings(),
              createPolicyBasedRouteRetry);
      clientSettingsBuilder
          .createPolicyBasedRouteSettings()
          .setRetrySettings(createPolicyBasedRouteRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createPolicyBasedRoute from properties.");
      }
    }
    Retry deletePolicyBasedRouteRetry = clientProperties.getDeletePolicyBasedRouteRetry();
    if (deletePolicyBasedRouteRetry != null) {
      RetrySettings deletePolicyBasedRouteRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deletePolicyBasedRouteSettings().getRetrySettings(),
              deletePolicyBasedRouteRetry);
      clientSettingsBuilder
          .deletePolicyBasedRouteSettings()
          .setRetrySettings(deletePolicyBasedRouteRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deletePolicyBasedRoute from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public PolicyBasedRoutingServiceClient policyBasedRoutingServiceClient(
      PolicyBasedRoutingServiceSettings policyBasedRoutingServiceSettings) throws IOException {
    return PolicyBasedRoutingServiceClient.create(policyBasedRoutingServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-policy-based-routing-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
