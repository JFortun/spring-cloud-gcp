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

package com.google.cloud.asset.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.AssetServiceSettings;
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
 * Auto-configuration for {@link AssetServiceClient}.
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
@ConditionalOnClass(AssetServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.asset.v1.spring.auto.asset-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(AssetServiceSpringProperties.class)
public class AssetServiceSpringAutoConfiguration {
  private final AssetServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER = LogFactory.getLog(AssetServiceSpringAutoConfiguration.class);

  protected AssetServiceSpringAutoConfiguration(
      AssetServiceSpringProperties clientProperties, CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from AssetService-specific configuration");
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
  public TransportChannelProvider defaultAssetServiceTransportChannelProvider() {
    return AssetServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a AssetServiceClient bean configured to use the default credentials provider (obtained
   * with assetServiceCredentials()) and its default transport channel provider
   * (defaultAssetServiceTransportChannelProvider()). It also configures the quota project ID if
   * provided. It will configure an executor provider in case there is more than one thread
   * configured in the client
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in AssetServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   */
  @Bean
  @ConditionalOnMissingBean
  public AssetServiceSettings assetServiceSettings(
      @Qualifier("defaultAssetServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    AssetServiceSettings.Builder clientSettingsBuilder =
        AssetServiceSettings.newBuilder()
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
          AssetServiceSettings.defaultExecutorProviderBuilder()
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
          AssetServiceSettings.defaultHttpJsonTransportProviderBuilder().build());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using HTTP transport channel");
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings exportAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.exportAssetsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.exportAssetsSettings().setRetrySettings(exportAssetsRetrySettings);

      RetrySettings listAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listAssetsSettings().setRetrySettings(listAssetsRetrySettings);

      RetrySettings batchGetAssetsHistoryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.batchGetAssetsHistorySettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .batchGetAssetsHistorySettings()
          .setRetrySettings(batchGetAssetsHistoryRetrySettings);

      RetrySettings createFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createFeedSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.createFeedSettings().setRetrySettings(createFeedRetrySettings);

      RetrySettings getFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeedSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getFeedSettings().setRetrySettings(getFeedRetrySettings);

      RetrySettings listFeedsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeedsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listFeedsSettings().setRetrySettings(listFeedsRetrySettings);

      RetrySettings updateFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateFeedSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateFeedSettings().setRetrySettings(updateFeedRetrySettings);

      RetrySettings deleteFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteFeedSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteFeedSettings().setRetrySettings(deleteFeedRetrySettings);

      RetrySettings searchAllResourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchAllResourcesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .searchAllResourcesSettings()
          .setRetrySettings(searchAllResourcesRetrySettings);

      RetrySettings searchAllIamPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchAllIamPoliciesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .searchAllIamPoliciesSettings()
          .setRetrySettings(searchAllIamPoliciesRetrySettings);

      RetrySettings analyzeIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .analyzeIamPolicySettings()
          .setRetrySettings(analyzeIamPolicyRetrySettings);

      RetrySettings analyzeIamPolicyLongrunningRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeIamPolicyLongrunningSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .analyzeIamPolicyLongrunningSettings()
          .setRetrySettings(analyzeIamPolicyLongrunningRetrySettings);

      RetrySettings analyzeMoveRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeMoveSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.analyzeMoveSettings().setRetrySettings(analyzeMoveRetrySettings);

      RetrySettings queryAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.queryAssetsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.queryAssetsSettings().setRetrySettings(queryAssetsRetrySettings);

      RetrySettings createSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSavedQuerySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .createSavedQuerySettings()
          .setRetrySettings(createSavedQueryRetrySettings);

      RetrySettings getSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSavedQuerySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getSavedQuerySettings().setRetrySettings(getSavedQueryRetrySettings);

      RetrySettings listSavedQueriesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSavedQueriesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .listSavedQueriesSettings()
          .setRetrySettings(listSavedQueriesRetrySettings);

      RetrySettings updateSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSavedQuerySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .updateSavedQuerySettings()
          .setRetrySettings(updateSavedQueryRetrySettings);

      RetrySettings deleteSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSavedQuerySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .deleteSavedQuerySettings()
          .setRetrySettings(deleteSavedQueryRetrySettings);

      RetrySettings batchGetEffectiveIamPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.batchGetEffectiveIamPoliciesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .batchGetEffectiveIamPoliciesSettings()
          .setRetrySettings(batchGetEffectiveIamPoliciesRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry exportAssetsRetry = clientProperties.getExportAssetsRetry();
    if (exportAssetsRetry != null) {
      RetrySettings exportAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.exportAssetsSettings().getRetrySettings(), exportAssetsRetry);
      clientSettingsBuilder.exportAssetsSettings().setRetrySettings(exportAssetsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for exportAssets from properties.");
      }
    }
    Retry listAssetsRetry = clientProperties.getListAssetsRetry();
    if (listAssetsRetry != null) {
      RetrySettings listAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listAssetsSettings().getRetrySettings(), listAssetsRetry);
      clientSettingsBuilder.listAssetsSettings().setRetrySettings(listAssetsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listAssets from properties.");
      }
    }
    Retry batchGetAssetsHistoryRetry = clientProperties.getBatchGetAssetsHistoryRetry();
    if (batchGetAssetsHistoryRetry != null) {
      RetrySettings batchGetAssetsHistoryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.batchGetAssetsHistorySettings().getRetrySettings(),
              batchGetAssetsHistoryRetry);
      clientSettingsBuilder
          .batchGetAssetsHistorySettings()
          .setRetrySettings(batchGetAssetsHistoryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for batchGetAssetsHistory from properties.");
      }
    }
    Retry createFeedRetry = clientProperties.getCreateFeedRetry();
    if (createFeedRetry != null) {
      RetrySettings createFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createFeedSettings().getRetrySettings(), createFeedRetry);
      clientSettingsBuilder.createFeedSettings().setRetrySettings(createFeedRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for createFeed from properties.");
      }
    }
    Retry getFeedRetry = clientProperties.getGetFeedRetry();
    if (getFeedRetry != null) {
      RetrySettings getFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getFeedSettings().getRetrySettings(), getFeedRetry);
      clientSettingsBuilder.getFeedSettings().setRetrySettings(getFeedRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getFeed from properties.");
      }
    }
    Retry listFeedsRetry = clientProperties.getListFeedsRetry();
    if (listFeedsRetry != null) {
      RetrySettings listFeedsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listFeedsSettings().getRetrySettings(), listFeedsRetry);
      clientSettingsBuilder.listFeedsSettings().setRetrySettings(listFeedsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listFeeds from properties.");
      }
    }
    Retry updateFeedRetry = clientProperties.getUpdateFeedRetry();
    if (updateFeedRetry != null) {
      RetrySettings updateFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateFeedSettings().getRetrySettings(), updateFeedRetry);
      clientSettingsBuilder.updateFeedSettings().setRetrySettings(updateFeedRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateFeed from properties.");
      }
    }
    Retry deleteFeedRetry = clientProperties.getDeleteFeedRetry();
    if (deleteFeedRetry != null) {
      RetrySettings deleteFeedRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteFeedSettings().getRetrySettings(), deleteFeedRetry);
      clientSettingsBuilder.deleteFeedSettings().setRetrySettings(deleteFeedRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteFeed from properties.");
      }
    }
    Retry searchAllResourcesRetry = clientProperties.getSearchAllResourcesRetry();
    if (searchAllResourcesRetry != null) {
      RetrySettings searchAllResourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchAllResourcesSettings().getRetrySettings(),
              searchAllResourcesRetry);
      clientSettingsBuilder
          .searchAllResourcesSettings()
          .setRetrySettings(searchAllResourcesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for searchAllResources from properties.");
      }
    }
    Retry searchAllIamPoliciesRetry = clientProperties.getSearchAllIamPoliciesRetry();
    if (searchAllIamPoliciesRetry != null) {
      RetrySettings searchAllIamPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.searchAllIamPoliciesSettings().getRetrySettings(),
              searchAllIamPoliciesRetry);
      clientSettingsBuilder
          .searchAllIamPoliciesSettings()
          .setRetrySettings(searchAllIamPoliciesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for searchAllIamPolicies from properties.");
      }
    }
    Retry analyzeIamPolicyRetry = clientProperties.getAnalyzeIamPolicyRetry();
    if (analyzeIamPolicyRetry != null) {
      RetrySettings analyzeIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeIamPolicySettings().getRetrySettings(),
              analyzeIamPolicyRetry);
      clientSettingsBuilder
          .analyzeIamPolicySettings()
          .setRetrySettings(analyzeIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for analyzeIamPolicy from properties.");
      }
    }
    Retry analyzeIamPolicyLongrunningRetry = clientProperties.getAnalyzeIamPolicyLongrunningRetry();
    if (analyzeIamPolicyLongrunningRetry != null) {
      RetrySettings analyzeIamPolicyLongrunningRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeIamPolicyLongrunningSettings().getRetrySettings(),
              analyzeIamPolicyLongrunningRetry);
      clientSettingsBuilder
          .analyzeIamPolicyLongrunningSettings()
          .setRetrySettings(analyzeIamPolicyLongrunningRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for analyzeIamPolicyLongrunning from properties.");
      }
    }
    Retry analyzeMoveRetry = clientProperties.getAnalyzeMoveRetry();
    if (analyzeMoveRetry != null) {
      RetrySettings analyzeMoveRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.analyzeMoveSettings().getRetrySettings(), analyzeMoveRetry);
      clientSettingsBuilder.analyzeMoveSettings().setRetrySettings(analyzeMoveRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for analyzeMove from properties.");
      }
    }
    Retry queryAssetsRetry = clientProperties.getQueryAssetsRetry();
    if (queryAssetsRetry != null) {
      RetrySettings queryAssetsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.queryAssetsSettings().getRetrySettings(), queryAssetsRetry);
      clientSettingsBuilder.queryAssetsSettings().setRetrySettings(queryAssetsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for queryAssets from properties.");
      }
    }
    Retry createSavedQueryRetry = clientProperties.getCreateSavedQueryRetry();
    if (createSavedQueryRetry != null) {
      RetrySettings createSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.createSavedQuerySettings().getRetrySettings(),
              createSavedQueryRetry);
      clientSettingsBuilder
          .createSavedQuerySettings()
          .setRetrySettings(createSavedQueryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for createSavedQuery from properties.");
      }
    }
    Retry getSavedQueryRetry = clientProperties.getGetSavedQueryRetry();
    if (getSavedQueryRetry != null) {
      RetrySettings getSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getSavedQuerySettings().getRetrySettings(), getSavedQueryRetry);
      clientSettingsBuilder.getSavedQuerySettings().setRetrySettings(getSavedQueryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getSavedQuery from properties.");
      }
    }
    Retry listSavedQueriesRetry = clientProperties.getListSavedQueriesRetry();
    if (listSavedQueriesRetry != null) {
      RetrySettings listSavedQueriesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listSavedQueriesSettings().getRetrySettings(),
              listSavedQueriesRetry);
      clientSettingsBuilder
          .listSavedQueriesSettings()
          .setRetrySettings(listSavedQueriesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for listSavedQueries from properties.");
      }
    }
    Retry updateSavedQueryRetry = clientProperties.getUpdateSavedQueryRetry();
    if (updateSavedQueryRetry != null) {
      RetrySettings updateSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateSavedQuerySettings().getRetrySettings(),
              updateSavedQueryRetry);
      clientSettingsBuilder
          .updateSavedQuerySettings()
          .setRetrySettings(updateSavedQueryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for updateSavedQuery from properties.");
      }
    }
    Retry deleteSavedQueryRetry = clientProperties.getDeleteSavedQueryRetry();
    if (deleteSavedQueryRetry != null) {
      RetrySettings deleteSavedQueryRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteSavedQuerySettings().getRetrySettings(),
              deleteSavedQueryRetry);
      clientSettingsBuilder
          .deleteSavedQuerySettings()
          .setRetrySettings(deleteSavedQueryRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for deleteSavedQuery from properties.");
      }
    }
    Retry batchGetEffectiveIamPoliciesRetry =
        clientProperties.getBatchGetEffectiveIamPoliciesRetry();
    if (batchGetEffectiveIamPoliciesRetry != null) {
      RetrySettings batchGetEffectiveIamPoliciesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.batchGetEffectiveIamPoliciesSettings().getRetrySettings(),
              batchGetEffectiveIamPoliciesRetry);
      clientSettingsBuilder
          .batchGetEffectiveIamPoliciesSettings()
          .setRetrySettings(batchGetEffectiveIamPoliciesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for batchGetEffectiveIamPolicies from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  @Bean
  @ConditionalOnMissingBean
  public AssetServiceClient assetServiceClient(AssetServiceSettings assetServiceSettings)
      throws IOException {
    return AssetServiceClient.create(assetServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-asset-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
