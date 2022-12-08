package edu.bo.ucb.express_app.DependecyInyection

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import edu.bo.ucb.express_app.Data.Repositories.CharacterRepositoryImplementation
import edu.bo.ucb.express_app.Domain.Repositories.CharacterRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun bindCharacterRepository(impl: CharacterRepositoryImplementation): CharacterRepository
}